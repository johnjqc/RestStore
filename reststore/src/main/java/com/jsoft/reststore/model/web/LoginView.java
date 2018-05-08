package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class LoginView implements Serializable {

    private static final long serialVersionUID = 1L;

    private String user;

    private String password;

}
