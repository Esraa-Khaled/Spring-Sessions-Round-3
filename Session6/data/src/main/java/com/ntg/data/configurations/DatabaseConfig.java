package com.ntg.data.configurations;

import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {


//    @Value("${database_username}")
//    String username;
//    @Value("${database_url}")
//    String url;
//    @Value("${database_password}")
//    String password;

//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource datasource = new DriverManagerDataSource();
//        datasource.setUrl(url);
//        datasource.setUsername(username);
//        datasource.setPassword(password);
//        return datasource;
//    }

//    @Bean
//    public JdbcTemplate getJdbcTemplate() {
//        return new JdbcTemplate();
//    }
}
