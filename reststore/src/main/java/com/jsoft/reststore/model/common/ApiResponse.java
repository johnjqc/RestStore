package com.jsoft.reststore.model.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * API response base message
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@JsonInclude(value = Include.NON_NULL)
@XmlRootElement(name = "response")
@XmlType(propOrder = {"description", "code", "error"})
public class ApiResponse implements Serializable {

    /**
     * The specific Serial version UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * A brief description with the result of the operation
     */
    private String description;

    /**
     * The response code.
     */
    private String code;

    /**
     * The message exception
     */
    private String message;

    /**
     * @return A brief description with the result of the operation
     */
    @XmlElement
    public String getDescription() {

        return description;
    }

    /**
     * @return the code
     */
    @XmlElement
    public String getCode() {

        return code;
    }

    /**
     * Sets the api response code and description from an ApiResponseCode object.
     *
     * @param apiResponseCode the object that contains the code id and description.
     */
    public void setApiResponseCode(ApiResponseCode apiResponseCode) {

        this.code = apiResponseCode.getId();
        this.description = apiResponseCode.getDescription();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
