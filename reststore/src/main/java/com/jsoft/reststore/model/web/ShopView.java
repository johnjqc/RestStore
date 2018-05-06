package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class ShopView implements Serializable {

    private static final long serialVersionUID = 1L;

    private String shopId;

    private String address;

    private String schedule;

    private String shopName;
}
