package com.jsoft.reststore.model.converter;

import com.jsoft.reststore.model.Shop;
import com.jsoft.reststore.model.web.ShopView;

/**
 * Utility class to convert {@link Shop} between web and domain.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public final class ShopConverter {

    // The private constructor by utility class
    private  ShopConverter(){}

    /**
     * Converts a domain layer Shop to a web layer Shop
     *
     * @param shop
     *            the domain {@link Shop}
     * @return the web {@link ShopView}
     */
    public static ShopView domainToWeb(Shop shop) {
        ShopView result = new ShopView();

        result.setShopId(shop.getShopId());
        result.setShopName(shop.getShopName());
        result.setAddress(shop.getAddress());
        result.setSchedule(shop.getSchedule());

        return result;
    }

    /**
     * Converts a web layer Shop to a domain layer Shop
     *
     * @param shop
     *            the web {@link ShopView}
     * @return the domain {@link Shop}
     */
    public static Shop webToDomain(ShopView shop) {
        Shop result = new Shop();

        result.setShopId(shop.getShopId());
        result.setShopName(shop.getShopName());
        result.setAddress(shop.getAddress());
        result.setSchedule(shop.getSchedule());

        return result;
    }

}
