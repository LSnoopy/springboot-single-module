package org.knowleaf.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        basePackages = {"org.knowleaf.common.mapper.second"},// mapper 所在包路径
        sqlSessionTemplateRef = "secondSqlSessionTemplate")
public class MybatisConfigSecond {

    private static String mapperResourcePath;

    @Resource
//    @Qualifier("secondDataSource")
    private DataSource secondDataSource;

    @Bean
    public SqlSessionTemplate secondSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(secondSqlSessionFactory());
    }

    @Bean
    public DataSourceTransactionManager secondTransactionManager() {
        return new DataSourceTransactionManager(secondDataSource);
    }

    @Bean
    public SqlSessionFactory secondSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(secondDataSource);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources(mapperResourcePath));
        return factoryBean.getObject();
    }

    @Value("${mybatis.config.mapper.resource.path.second}")
    public void setMapperResourcePath(String mapperResourcePath) {
        MybatisConfigSecond.mapperResourcePath = mapperResourcePath;
    }
}
