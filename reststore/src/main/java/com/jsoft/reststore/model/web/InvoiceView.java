package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@EqualsAndHashCode
public class InvoiceView implements Serializable {

    private static final long serialVersionUID = 1L;

    private long invoiceId;

    private BigDecimal amount;

    private Timestamp buyDate;

    private List<BuyView> buys;

    private ClientView client;
}
