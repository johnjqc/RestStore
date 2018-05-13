package com.jsoft.reststore.model;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * This class represents a Inventory.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Entity
@EqualsAndHashCode
@GenericGenerator(name = "inventory_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = { @org.hibernate.annotations.Parameter(name = "sequence_name", value = "inventory_seq"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="inventory_seq")
    @Column(name="inventory_id")
    private Long inventoryId;

    private BigDecimal total;

    //bi-directional many-to-one association to Buy
    @OneToMany(mappedBy="inventory")
    private List<Buy> buys;

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

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<Buy> getBuys() {
        return this.buys;
    }

    public void setBuys(List<Buy> buys) {
        this.buys = buys;
    }

    public Buy addBuy(Buy buy) {
        getBuys().add(buy);
        buy.setInventory(this);

        return buy;
    }

    public Buy removeBuy(Buy buy) {
        getBuys().remove(buy);
        buy.setInventory(null);

        return buy;
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
