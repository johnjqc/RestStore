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

    @Column(name="total_amount")
    private BigDecimal totalAmount;

    @Column(name="total_product")
    private BigDecimal totalProduct;

    //bi-directional many-to-one association to Inventory
    @ManyToOne
    @JoinColumn(name="inventory_id")
    private Inventory inventory;

    //bi-directional many-to-one association to Invoice
    @ManyToOne
    @JoinColumn(name="invoice_id")
    private Invoice invoice;

    public Buy() {
    }

    public Long getBuyId() {
        return this.buyId;
    }

    public void setBuyId(Long buyId) {
        this.buyId = buyId;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalProduct() {
        return this.totalProduct;
    }

    public void setTotalProduct(BigDecimal totalProduct) {
        this.totalProduct = totalProduct;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Invoice getInvoice() {
        return this.invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

}
