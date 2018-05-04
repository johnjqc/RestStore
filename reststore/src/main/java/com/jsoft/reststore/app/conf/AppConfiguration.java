/**
 * PayU Latam - Copyright (c) 2013 - 2017
 * http://www.payu.com.co
 * Date: 06/12/2017
 */
package com.jsoft.reststore.app.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.zaxxer.hikari.HikariDataSource;

/**
 * Application configuration.
 *
 * @author <a href="carlos.ruiz@beitech.co">Carlos Fernando Ruiz Nieto</a>
 * @version 0.0.1
 * @since 0.0.1
 */
@PropertySource(value = "file:${POL_HOME}/bureau-api/conf/bureau-api.properties")
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.payulatam.bureau.api" })
@EnableJpaRepositories(basePackages = { "com.payulatam.bureau.api.repositories.jpa" })						
@EntityScan(basePackages = { "com.payulatam.bureau.api.model" })
@Configuration
public class AppConfiguration {

	/** The database name property for data source */
	private static final String DATABASE_NAME_PROPERTY = "databaseName";

	/** The server name property for data source */
	private static final String SERVER_NAME_PROPERTY = "serverName";

	/** The port number property for data source */
	private static final String PORT_NUMBER_PROPERTY = "portNumber";

	/** The JDBC class name */
	@Value("${jdbc.dataSourceClassName}")
	private String dataSourceClassName;

	/** The JDBC user name */
	@Value("${jdbc.user}")
	private String username;

	/** The JDBC user password */
	@Value("${jdbc.password}")
	private String password;

	/** The database name */
	@Value("${dataSource.database}")
	private String database;

	/** The database server */
	@Value("${dataSource.server}")
	private String server;

	/** The database port */
	@Value("${dataSource.port}")
	private String port;
		
	/**
	 * The data source bean
	 * 
	 * @author <a href="john.quiroga@payulatam.com">John Quiroga</a>
	 */
	@Bean
	public DataSource dataSource() {

		Properties dsProperties = new Properties();
		dsProperties.setProperty(DATABASE_NAME_PROPERTY, database);
		dsProperties.setProperty(SERVER_NAME_PROPERTY, server);
		dsProperties.setProperty(PORT_NUMBER_PROPERTY, port);

		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDataSourceClassName(dataSourceClassName);
		dataSource.setDataSourceProperties(dsProperties);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		return dataSource;
	}

}