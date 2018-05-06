package com.jsoft.reststore.model.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "clientResponse")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ClientResponse extends ApiResponse {

    /**
     * The specific Serial version UID
     */
    private static final long serialVersionUID = 1L;

    private ClientView client;

    private List<ClientView> clientList;
}
