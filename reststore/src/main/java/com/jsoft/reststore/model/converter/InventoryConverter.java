package com.jsoft.reststore.model.converter;

import com.jsoft.reststore.model.Inventory;
import com.jsoft.reststore.model.web.InventoryView;

/**
 * Utility class to convert {@link Inventory} between web and domain.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public final class InventoryConverter {

    // The private constructor for utility class
    private InventoryConverter() {}

    /**
     * Converts a domain layer Inventory to a web layer Inventory
     *
     * @param Inventory
     *            the domain {@link Inventory}
     * @return the web {@link InventoryView}
     */
    public static InventoryView domainToWeb(Inventory Inventory) {
        InventoryView result = new InventoryView();

        return result;
    }

    /**
     * Converts a web layer Inventory to a domain layer Inventory
     *
     * @param Inventory
     *            the web {@link InventoryView}
     * @return the domain {@link Inventory}
     */
    public static Inventory webToDomain(InventoryView Inventory) {
        Inventory result = new Inventory();


        return  result;
    }
}
