package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
public class BuyViewResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal totalAmount;

    private Long productId;

    private BigDecimal productAmount;

    private int totalProduct;

    private Long buyId;

    private LocalDateTime creationDate;

}
