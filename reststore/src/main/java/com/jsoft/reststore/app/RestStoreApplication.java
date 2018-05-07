package com.jsoft.reststore.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class used to run the spring boot application.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@SpringBootApplication
public class RestStoreApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String... args) {

		SpringApplication.run(RestStoreApplication.class, args);
	}
}
