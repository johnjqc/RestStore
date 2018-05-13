package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode
public class BuyView implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long buyId;

    private String name;

    private BigDecimal totalAmount;

    private BigDecimal totalProduct;

}
