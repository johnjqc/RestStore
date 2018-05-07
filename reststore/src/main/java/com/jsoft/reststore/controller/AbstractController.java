package com.jsoft.reststore.controller;

import com.jsoft.reststore.model.common.ApiResponse;
import com.jsoft.reststore.model.common.ApiResponseCode;
import com.jsoft.reststore.model.common.StoreApiException;
import org.slf4j.Logger;

/**
 * An abstract class for common logic of controllers.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public abstract class AbstractController {

    /**
     * Returns the class logger
     *
     * @return Logger
     */
    abstract Logger getLogger();

    /**
     * Returns the Default Response Code
     *
     * @return ApiResponseCode
     */
    ApiResponseCode getDefaultResponseCode() {
        return ApiResponseCode.FAILED;
    }

    /**
     * Handles exceptions by logging the error message and returning the given ApiResponseCode in
     * the given ApiResponse object
     *
     * @param e        the original exception
     * @param response ApiResponse object
     */
    void handleException(StoreApiException e, ApiResponse response) {

        if (e.hasResponseCode()) {
            getLogger().warn("Known Exception: {}", e.getResponseCode().getDescription());
            response.setApiResponseCode(e.getResponseCode());
            response.setMessage(e.getRootMessage());
        } else {
            getLogger().error(getDefaultResponseCode().getDescription(), e);
            response.setApiResponseCode(getDefaultResponseCode());
            response.setMessage(e.getRootMessage());
        }
    }

    /**
     * Handles known errors by logging the error message and returning the given ApiResponseCode in
     * the given ApiResponse object
     *
     * @param response       ApiResponse object
     * @param code           the ApiResponseCode to log
     * @param additionalInfo additionalInfo to be appended at the end of the log
     */
    void handleKnownError(ApiResponse response, ApiResponseCode code, String additionalInfo) {

        getLogger().warn("Known Exception {}: {}", code.getDescription(), additionalInfo);
        response.setApiResponseCode(code);
    }

}
