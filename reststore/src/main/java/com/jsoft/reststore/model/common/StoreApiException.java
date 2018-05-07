package com.jsoft.reststore.model.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * General purpose API exception
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class StoreApiException extends Exception {

	/**
	 * The default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/** The optional {@link ApiResponseCode} */
	private ApiResponseCode responseCode;

	/**
	 * Default Constructor
	 */
	public StoreApiException() {
		super();
	}

	/**
	 * The constructor given an exception
	 * 
	 * @param e
	 *            the exception
	 */
	public StoreApiException(Exception e) {
		super(e);
	}

	/**
	 * Constructor given an error message
	 * 
	 * @param message
	 *            the string message
	 */
	public StoreApiException(String message) {
		super(message);
	}

	/**
	 * Constructor given an error message and a cause exception
	 * 
	 * @param message
	 *            the string message
	 * @param e
	 *            the exception
	 */
	public StoreApiException(String message, Throwable e) {
		super(message, e);
	}

	/**
	 * Constructor given an ApiResponseCode to use as message
	 * 
	 * @param code
	 *            the ApiResponseCode
	 */
	public StoreApiException(ApiResponseCode code) {
		super(code.getDescription());
		this.responseCode = code;
	}

	/**
	 * Constructor given an ApiResponseCode to use as message
	 * 
	 * @param code
	 *            the ApiResponseCode
	 */
	public StoreApiException(ApiResponseCode code, String details) {
		super(code.getDescription() + ": " + details);
		this.responseCode = code;
	}

	/**
	 * Constructor given an ApiResponseCode to be taken as the exception message and a cause
	 * exception
	 * 
	 * @param code
	 *            the code
	 * @param e
	 *            the exception
	 */
	public StoreApiException(ApiResponseCode code, Throwable e) {
		super(e);

		if (e instanceof StoreApiException) {
			StoreApiException lae = ((StoreApiException) e);
			this.responseCode = lae.hasResponseCode() ? lae.getResponseCode() : code;
		}
		else {
			this.responseCode = code;
		}
	}

	/**
	 * Checks if there was an responseCode attached to the exception
	 * 
	 * @return true if there is an {@link ApiResponseCode}
	 */
	public boolean hasResponseCode() {

		return this.responseCode != null;
	}

	/**
	 * Returns the root cause message for this exception
	 *
	 * @return root cause if an exception was given or the message provided
	 */
	public String getRootMessage() {

		if (getCause() != null) {
			return ExceptionUtils.getRootCauseMessage(this);
		}
		else {
			return getMessage();
		}
	}
}
