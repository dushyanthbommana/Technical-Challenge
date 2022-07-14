package com.demo.nace.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * This class contains configuration beans
 */
@Configuration
public class DataSourceConfiguration {

    @Value("${jdbc.datasource.url}")
    private String driverClassname;

    @Value("jdbc.datasource.username")
    private String userName;

    @Value("jdbc.datasource.password")
    private String passWord;

    @Value("jdbc.datasource.driver-class-name")
    private String url;

    /**
     * This method prepares a bean DataSourceConfig
     */

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("org.mariadb.jdbc.Driver")
                .url("jdbc:mariadb://localhost:3306/nace")
                .username("root")
                .password("maria98")
                .build();
    }

}
