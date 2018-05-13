package com.jsoft.reststore.model;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * This class represents a Invoice.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Entity
@EqualsAndHashCode
@GenericGenerator(name = "invoice_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = { @Parameter(name = "sequence_name", value = "invoice_seq"),
                @Parameter(name = "increment_size", value = "1") })
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="invoice_seq")
    @Column(name="invoice_id")
    private long invoiceId;

    private BigDecimal amount;

    @Column(name="buy_date")
    private Timestamp buyDate;

    //bi-directional many-to-one association to Buy
    @OneToMany(mappedBy="invoice")
    private List<Buy> buys;

    //bi-directional many-to-one association to Client
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    public Invoice() {
    }

    public long getInvoiceId() {
        return this.invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getBuyDate() {
        return this.buyDate;
    }

    public void setBuyDate(Timestamp buyDate) {
        this.buyDate = buyDate;
    }

    public List<Buy> getBuys() {
        return this.buys;
    }

    public void setBuys(List<Buy> buys) {
        this.buys = buys;
    }

    public Buy addBuy(Buy buy) {
        getBuys().add(buy);
        buy.setInvoice(this);

        return buy;
    }

    public Buy removeBuy(Buy buy) {
        getBuys().remove(buy);
        buy.setInvoice(null);

        return buy;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
