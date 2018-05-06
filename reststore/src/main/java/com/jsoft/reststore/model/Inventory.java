package com.jsoft.reststore.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@EqualsAndHashCode
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="INVENTORY_INEVNTARIOID_GENERATOR", sequenceName="INVENTORY_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INVENTORY_INEVNTARIOID_GENERATOR")
    @Column(name="inevntario_id")
    private String inevntarioId;

    private String existencia;

    //bi-directional many-to-one association to Product
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    //bi-directional many-to-one association to Shop
    @ManyToOne
    @JoinColumn(name="shop_id")
    private Shop shop;

    public Inventory() {
    }

    public String getInevntarioId() {
        return this.inevntarioId;
    }

    public void setInevntarioId(String inevntarioId) {
        this.inevntarioId = inevntarioId;
    }

    public String getExistencia() {
        return this.existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shop getShop() {
        return this.shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

}
