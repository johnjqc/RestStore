package com.jsoft.reststore.model;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * This class represents a Product.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Entity
@EqualsAndHashCode
@GenericGenerator(name = "product_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = { @org.hibernate.annotations.Parameter(name = "sequence_name", value = "product_seq"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
    @Column(name="product_id")
    private Long productId;

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

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
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
