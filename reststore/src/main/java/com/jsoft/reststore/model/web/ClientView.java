package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode
public class ClientView implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long clientId;

    @NotNull
    private Integer age;

    @NotNull
    private String clientName;

    @NotNull
    private String clientUser;

    @NotNull
    private BigDecimal document;

    @Email
    private String email;

    @NotNull
    private String password;

}
