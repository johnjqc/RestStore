package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode
public class ProductView implements Serializable {

    private static final long serialVersionUID = 1L;

    private String productId;

    private String barcode;

    private BigDecimal cost;

    private String description;

    private String productName;
}
