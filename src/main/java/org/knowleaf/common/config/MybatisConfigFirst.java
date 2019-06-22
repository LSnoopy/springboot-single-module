package org.knowleaf.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @ author liujianjian
 * @ date 2019/6/22 20:44
 */
@Configuration
@MapperScan(
        basePackages = {"org.knowleaf.common.mapper.first"},// mapper 所在包路径
        sqlSessionTemplateRef = "firstSqlSessionTemplate")
public class MybatisConfigFirst {

    private static String mapperResourcePath;

    @Resource
//    @Qualifier("firstDataSource")
    private DataSource firstDataSource;


    @Bean
    @Primary
    public SqlSessionTemplate firstSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(firstSqlSessionFactory());
    }

    @Bean
    @Primary
    public DataSourceTransactionManager firstTransactionManager() {
        return new DataSourceTransactionManager(firstDataSource);
    }

    @Bean
    @Primary
    public SqlSessionFactory firstSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(firstDataSource);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources(mapperResourcePath)); // 2. xml 所在路径
        return factoryBean.getObject();
    }

    @Value("${mybatis.config.mapper.resource.path.first}")
    public void setMapperResourcePath(String mapperResourcePath) {
        MybatisConfigFirst.mapperResourcePath = mapperResourcePath;
    }
}
