package com.jsoft.reststore.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@EqualsAndHashCode
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="PRODUCT_PRODUCTID_GENERATOR", sequenceName="PRODUCT_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_PRODUCTID_GENERATOR")
    @Column(name="product_id")
    private String productId;

    private String barcode;

    private BigDecimal cost;

    private String description;

    @Column(name="product_name")
    private String productName;

    //bi-directional many-to-one association to Inventory
    @OneToMany(mappedBy="product")
    private List<Inventory> inventories;

    public Product() {
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Inventory> getInventories() {
        return this.inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Inventory addInventory(Inventory inventory) {
        getInventories().add(inventory);
        inventory.setProduct(this);

        return inventory;
    }

    public Inventory removeInventory(Inventory inventory) {
        getInventories().remove(inventory);
        inventory.setProduct(null);

        return inventory;
    }

}
