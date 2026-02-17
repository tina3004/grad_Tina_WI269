package com.springstudentpageassgn.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

    // PRIMARY → H2
    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "app.datasource.h2")
    public HikariDataSource primaryDataSource() {
        return new HikariDataSource();
    }

    // SECONDARY → POSTGRES
    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "app.datasource.postgres")
    public HikariDataSource secondaryDataSource() {
        return new HikariDataSource();
    }
}
