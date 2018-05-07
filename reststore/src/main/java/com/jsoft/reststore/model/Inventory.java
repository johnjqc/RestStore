package com.jsoft.reststore.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This class represents a Inventory.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Entity
@EqualsAndHashCode
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="INVENTORY_INVENTARIOID_GENERATOR", sequenceName="INVENTORY_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INVENTORY_INVENTARIOID_GENERATOR")
    @Column(name="inventory_id")
    private Long inventoryId;

    private String total;

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

    public Long getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getTotal() {
        return this.total;
    }

    public void setTotal(String existencia) {
        this.total = existencia;
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
