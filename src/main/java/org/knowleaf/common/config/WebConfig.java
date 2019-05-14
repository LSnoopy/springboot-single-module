package org.knowleaf.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //拦截器设置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration ir2 = registry.addInterceptor(urlParamDecodeInterceptor);
//        ir2.addPathPatterns("/**").excludePathPatterns("/friendlyT/error/**");
//
//        InterceptorRegistration ir = registry.addInterceptor(loginInterceptor);
//        ir.addPathPatterns("/friendlyT/**").excludePathPatterns("/friendlyT/error/**").excludePathPatterns("/friendlyT/common/**");
    }

    //使用fast json转换
    @Bean
    public HttpMessageConverters customConverters() {
        return getFastJsonConverter();
    }

    //Content Types
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        //设置响应头格式 application/json;charset=UTF-8
        configurer.strategies(getContentNegotiationList());
    }

    private HttpMessageConverters getFastJsonConverter() {
        //        QuoteFieldNames———-输出key时是否使用双引号,默认为true
//        WriteMapNullValue——–是否输出值为null的字段,默认为false
//        WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
//        WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
//        WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null
//        WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
        FastJsonHttpMessageConverter fjmc = new FastJsonHttpMessageConverter();
        FastJsonConfig conf = new FastJsonConfig();
        conf.setSerializerFeatures(SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty);
        fjmc.setFastJsonConfig(conf);
        return new HttpMessageConverters(fjmc);
    }

    //跨域设置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }

    private List<ContentNegotiationStrategy> getContentNegotiationList() {
        //设置响应头格式 application/json;charset=UTF-8
        List<ContentNegotiationStrategy> list = new ArrayList<>();
        list.add((webRequest) -> {
            List<MediaType> mediaTypes = new ArrayList<>();
            mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
            return mediaTypes;
        });
        return list;
    }

}
