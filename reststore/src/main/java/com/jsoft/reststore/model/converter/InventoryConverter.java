package com.jsoft.reststore.model.converter;

import com.jsoft.reststore.model.Inventory;
import com.jsoft.reststore.model.web.InventoryView;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
     * @param inventory
     *            the domain {@link Inventory}
     * @return the web {@link InventoryView}
     */
    public static InventoryView domainToWeb(Inventory inventory) {
        InventoryView result = new InventoryView();

        result.setInventoryId(inventory.getInventoryId());
        result.setTotal(inventory.getTotal());
        result.setShop(ShopConverter.domainToWeb(inventory.getShop()));
        result.setProduct(ProductConverter.domainToWeb(inventory.getProduct()));
        result.setBuys(new ArrayList<>());
        result.getBuys().addAll(
                inventory.getBuys().stream().map(BuyConverter::domainToWeb).collect(Collectors.toList())
        );

        return result;
    }

    /**
     * Converts a web layer Inventory to a domain layer Inventory
     *
     * @param inventory
     *            the web {@link InventoryView}
     * @return the domain {@link Inventory}
     */
    public static Inventory webToDomain(InventoryView inventory) {
        Inventory result = new Inventory();

        result.setInventoryId(inventory.getInventoryId());
        result.setTotal(inventory.getTotal());
        result.setShop(ShopConverter.webToDomain(inventory.getShop()));
        result.setProduct(ProductConverter.webToDomain(inventory.getProduct()));
        result.setBuys(new ArrayList<>());
        result.getBuys().addAll(
                inventory.getBuys().stream().map(BuyConverter::webToDomain).collect(Collectors.toList())
        );

        return  result;
    }
}
