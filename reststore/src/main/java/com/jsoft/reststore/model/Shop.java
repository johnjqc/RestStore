package com.jsoft.reststore.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode
public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="SHOP_SHOPID_GENERATOR", sequenceName="SHOP_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHOP_SHOPID_GENERATOR")
    @Column(name="shop_id")
    private String shopId;

    private String address;

    private String schedule;

    @Column(name="shop_name")
    private String shopName;

    //bi-directional many-to-one association to Inventory
    @OneToMany(mappedBy="shop")
    private List<Inventory> inventories;

    public Shop() {
    }

    public String getShopId() {
        return this.shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchedule() {
        return this.schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getShopName() {
        return this.shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Inventory> getInventories() {
        return this.inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Inventory addInventory(Inventory inventory) {
        getInventories().add(inventory);
        inventory.setShop(this);

        return inventory;
    }

    public Inventory removeInventory(Inventory inventory) {
        getInventories().remove(inventory);
        inventory.setShop(null);

        return inventory;
    }

}
