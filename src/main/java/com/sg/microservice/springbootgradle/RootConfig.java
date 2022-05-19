package com.sg.microservice.springbootgradle;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;

//@Configuration
public class RootConfig {
	@Value("${DB_DRIVER}")
	private String dbDriver;
	@Value("${DB_URL}")
	private String databaseUrl;
	@Value("${DB_USER}")
	private String dbUser;
	@Value("${DB_PASSWORD}")
	private String dbPassword;
	
	//@Bean
	public DataSource datasource() {
		//HikariConfig hikariConfig = new HikariConfig();
		//hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
		//hikariConfig.setDriverClassName(dbDriver);
		//hikariConfig.setJdbcUrl("jdbc:mysql://192.168.48.128:3306/mariadbdev?useSSL=false");
		//hikariConfig.setJdbcUrl(databaseUrl);
		//hikariConfig.setUsername("mariauser");
		//hikariConfig.setUsername(dbUser);
		//hikariConfig.setPassword("password");
		//hikariConfig.setPassword(dbPassword);
		//HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		//return dataSource;
		return null;
	}

}
