package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@EqualsAndHashCode
public class ShopView implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long shopId;

    @NotNull
    private String address;

    @NotNull
    private String schedule;

    @NotNull
    private String shopName;
}
