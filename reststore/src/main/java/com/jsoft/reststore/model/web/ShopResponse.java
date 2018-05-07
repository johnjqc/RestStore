package com.jsoft.reststore.model.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jsoft.reststore.model.common.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "shopResponse")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ShopResponse extends ApiResponse {

    /**
     * The specific Serial version UID
     */
    private static final long serialVersionUID = 1L;

    private ShopView shop;

    private List<ShopView> shopList;
}
