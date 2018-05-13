package com.jsoft.reststore.model.converter;

import com.jsoft.reststore.model.Buy;
import com.jsoft.reststore.model.web.BuyView;

/**
 * Utility class to convert {@link Buy} between web and domain.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public final class BuyConverter {

    // The private constructor by utility class
    private BuyConverter(){}

    /**
     * Converts a domain layer Buy to a web layer buy
     *
     * @param buy
     *            the domain {@link Buy}
     * @return the web {@link BuyView}
     */
    public static BuyView domainToWeb(Buy buy) {
        BuyView result = new BuyView();

        result.setBuyId(buy.getBuyId());
        result.setInvoice(InvoiceConverter.domainToWeb(buy.getInvoice()));
        result.setInventory(InventoryConverter.domainToWeb(buy.getInventory()));
        result.setTotalProduct(buy.getTotalProduct());
        result.setTotalAmount(buy.getTotalAmount());

        return result;
    }

    /**
     * Converts a web layer Buy to a domain layer Buy
     *
     * @param buy
     *            the web {@link BuyView}
     * @return the domain {@link Buy}
     */
    public static Buy webToDomain(BuyView buy) {
        Buy result = new Buy();

        result.setBuyId(buy.getBuyId());
        result.setInvoice(InvoiceConverter.webToDomain(buy.getInvoice()));
        result.setInventory(InventoryConverter.webToDomain(buy.getInventory()));
        result.setTotalProduct(buy.getTotalProduct());
        result.setTotalAmount(buy.getTotalAmount());

        return  result;
    }

}
