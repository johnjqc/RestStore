package com.jsoft.reststore.model.converter;

import com.jsoft.reststore.model.Invoice;
import com.jsoft.reststore.model.web.InvoiceView;

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
     * @param Invoice
     *            the domain {@link Invoice}
     * @return the web {@link InvoiceView}
     */
    public static InvoiceView domainToWeb(Invoice Invoice) {
        InvoiceView result = new InvoiceView();

        return result;
    }

    /**
     * Converts a web layer Invoice to a domain layer Invoice
     *
     * @param Invoice
     *            the web {@link InvoiceView}
     * @return the domain {@link Invoice}
     */
    public static Invoice webToDomain(InvoiceView Invoice) {
        Invoice result = new Invoice();


        return  result;
    }

}
