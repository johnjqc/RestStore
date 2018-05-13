package com.jsoft.reststore.model.web;

import com.jsoft.reststore.model.Invoice;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@EqualsAndHashCode
public class BuyView implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long buyId;

    private BigDecimal totalAmount;

    private BigDecimal totalProduct;

    private InventoryView inventory;

    private InvoiceView invoice;

}
