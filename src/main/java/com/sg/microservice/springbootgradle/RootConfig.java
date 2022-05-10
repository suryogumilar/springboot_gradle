package com.sg.microservice.springbootgradle;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class RootConfig {
	@Bean
	public DataSource datasource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
		hikariConfig.setJdbcUrl("jdbc:mysql://192.168.48.128:3306/mariadbdev?useSSL=false");
		hikariConfig.setUsername("mariauser");
		hikariConfig.setPassword("password");
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}

}
