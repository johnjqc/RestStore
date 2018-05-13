package com.jsoft.reststore.test;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * Common Mockito Test Class
 * 
 * @since 0.0.
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 */
public abstract class AbstractMockitoTest {

	/**
	 * Init mocks for every child class
	 */
	@Before
	public void init() {

		MockitoAnnotations.initMocks(this);
	}

}
