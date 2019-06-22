package org.knowleaf.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @ author liujianjian
 * @ date 2019/6/22 20:13
 */
@Slf4j
@Configuration
public class DataSourceConfig {

    @Bean(name = "firstDataSource")
    @Primary
//    @Qualifier("firstDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource firstDataSource() {
        DataSource ds = DataSourceBuilder.create().build();
        log.info("第一个数据库连接池创建完成");
        return ds;
    }


    @Bean(name = "secondDataSource")
//    @Qualifier("secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource() {
        DataSource ds = DataSourceBuilder.create().build();
        log.info("第二个数据库连接池创建完成");
        return ds;
    }

}

