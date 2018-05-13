package com.jsoft.reststore.model.converter;

import com.jsoft.reststore.model.Invoice;
import com.jsoft.reststore.model.web.InvoiceView;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Utility class to convert {@link Invoice} between web and domain.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public final class InvoiceConverter {

    // The private constructor by utility class
    private InvoiceConverter() {}

    /**
     * Converts a domain layer Invoice to a web layer Invoice
     *
     * @param invoice
     *            the domain {@link Invoice}
     * @return the web {@link InvoiceView}
     */
    public static InvoiceView domainToWeb(Invoice invoice) {
        InvoiceView result = new InvoiceView();

        result.setInvoiceId(invoice.getInvoiceId());
        result.setAmount(invoice.getAmount());
        result.setBuyDate(invoice.getBuyDate());
        result.setClient(ClientConverter.domainToWeb(invoice.getClient()));
        result.setBuys(new ArrayList<>());
        result.getBuys().addAll(
                invoice.getBuys().stream().map(BuyConverter::domainToWeb).collect(Collectors.toList())
        );

        return result;
    }

    /**
     * Converts a web layer Invoice to a domain layer Invoice
     *
     * @param invoice
     *            the web {@link InvoiceView}
     * @return the domain {@link Invoice}
     */
    public static Invoice webToDomain(InvoiceView invoice) {
        Invoice result = new Invoice();

        result.setInvoiceId(invoice.getInvoiceId());
        result.setAmount(invoice.getAmount());
        result.setBuyDate(invoice.getBuyDate());
        result.setClient(ClientConverter.webToDomain(invoice.getClient()));
        result.setBuys(new ArrayList<>());
        result.getBuys().addAll(
                invoice.getBuys().stream().map(BuyConverter::webToDomain).collect(Collectors.toList())
        );

        return  result;
    }

}
