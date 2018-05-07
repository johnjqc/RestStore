package com.jsoft.reststore.model.common;

/**
 * API response message codes.
 * 
 * The response structure is explained as below:
 * 
 * XXYY
 * 
 * Where XX is the Store API component ID:
 * 
 * 11xx - General 
 * 12xx - Clients 
 * 13xx - Product
 * 14xx - Shop
 * 
 * And YY represents the component's code ID.
 * 
 * The 0 ID represents a SUCCESS message and 1 an unexpected error.
 * 
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public enum ApiResponseCode {

	/** The success result. */
	SUCCESS("0", "SUCCESS"),

	/** The failed result for unexpected problems. */
	FAILED("1", "Unexpected error"),

	ERROR_ON_DATABASE_QUERY("1101", "Error on database query"),

	ERROR_ON_DATABASE_STORE("1102", "Error on database store"),

	ERROR_ON_DATABASE_DELETE("1103", "Error on database delete"),

	CLIENT_CREATED("1201", "Client created"),

	CLIENT_DELETED("1202", "Client deleted"),

	CLIENT_UPDATED("1202", "Client updated"),

	PRODUCT_CREATED("1201", "Product created"),

	PRODUCT_DELETED("1202", "Product deleted"),

	PRODUCT_UPDATED("1202", "Product updated"),

	SHOP_CREATED("1201", "Shop created"),

	SHOP_DELETED("1202", "Shop deleted"),

	SHOP_UPDATED("1202", "Shop updated");


	/**
	 * The API response code id.
	 */
	private String id;

	/**
	 * The API response description.
	 */
	private String description;

	/**
	 * ApiResponseCode constructor.
	 * 
	 * @param id
	 *            the API response code ID.
	 * @param description
	 *            the API response code description.
	 */
	private ApiResponseCode(String id, String description) {

		this.id = id;
		this.description = description;
	}

	/**
	 * Gets the API response code id.
	 * 
	 * @return the API response code id.
	 */
	public String getId() {

		return id;
	}

	/**
	 * Gets the API response code description.
	 * 
	 * @return the API response code description.
	 */
	public String getDescription() {

		return description;
	}
}
