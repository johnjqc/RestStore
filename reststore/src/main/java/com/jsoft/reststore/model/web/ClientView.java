package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode
public class ClientView implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long clientId;

    private Integer age;

    private String clientName;

    private String clientUser;

    private BigDecimal document;

    private String email;

    private String password;

}
