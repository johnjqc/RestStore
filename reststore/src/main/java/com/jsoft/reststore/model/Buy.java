package com.jsoft.reststore.model;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * This class represents a Buy.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Entity
@EqualsAndHashCode
@GenericGenerator(name = "buy_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = { @Parameter(name = "sequence_name", value = "buy_seq"),
                @Parameter(name = "increment_size", value = "1") })
public class Buy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="buy_seq")
    @Column(name="buy_id")
    private Long buyId;

    private BigDecimal amount;

    @Column(name="client_id")
    private BigDecimal clientId;

    //bi-directional many-to-one association to Inventory
    @ManyToOne
    @JoinColumn(name="inventory_id")
    private Inventory inventory;

    //bi-directional many-to-one association to Product
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    public Buy() {
    }

    public long getBuyId() {
        return this.buyId;
    }

    public void setBuyId(long buyId) {
        this.buyId = buyId;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getClientId() {
        return this.clientId;
    }

    public void setClientId(BigDecimal clientId) {
        this.clientId = clientId;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
