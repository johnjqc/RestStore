package com.jsoft.reststore.model.converter;

import com.jsoft.reststore.model.Shop;
import com.jsoft.reststore.model.web.ShopView;

public final class ShopConverter {

    // The private constructor by utility class
    private  ShopConverter(){}

    public static ShopView webToDomain(Shop shop) {
        ShopView result = new ShopView();

        result.setShopId(shop.getShopId());
        result.setShopName(shop.getShopName());
        result.setAddress(shop.getAddress());
        result.setSchedule(shop.getSchedule());

        return result;
    }

    public static Shop domainToWeb(ShopView shop) {
        Shop result = new Shop();

        result.setShopId(shop.getShopId());
        result.setShopName(shop.getShopName());
        result.setAddress(shop.getAddress());
        result.setSchedule(shop.getSchedule());

        return result;
    }

}
