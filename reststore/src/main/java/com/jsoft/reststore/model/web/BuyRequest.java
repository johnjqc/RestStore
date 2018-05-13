package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Map;

@Data
@EqualsAndHashCode
public class BuyRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String user;

    private String password;

    private Long shopId;

    private Map<String, Integer> product;


}
