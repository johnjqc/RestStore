package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode
public class ProductView implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long productId;

    @NotNull
    private String barcode;

    @NotNull
    private BigDecimal cost;

    @NotNull
    private String description;

    @NotNull
    private String productName;
}
