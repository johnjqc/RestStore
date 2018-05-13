package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode
public class InventoryView implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long inventoryId;

    private BigDecimal total;

    private List<BuyView> buys;

    private ProductView product;

    private ShopView shop;

}
