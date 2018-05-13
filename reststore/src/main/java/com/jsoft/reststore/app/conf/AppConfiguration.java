package com.jsoft.reststore.app.conf;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Application configuration.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@PropertySource(value = "classpath:store.properties")
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.jsoft.reststore" })
@EnableJpaRepositories(basePackages = { "com.jsoft.reststore.repositories.jpa" })
@EntityScan(basePackages = { "com.jsoft.reststore.model" })
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
	 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
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
