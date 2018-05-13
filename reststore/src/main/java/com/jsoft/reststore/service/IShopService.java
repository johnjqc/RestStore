package com.jsoft.reststore.service;

import com.jsoft.reststore.model.Shop;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.impl.ShopService;

/**
 * The interface for {@link ShopService}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface IShopService extends IGenericService<Shop> {

    Shop findById(Long shopId) throws StoreApiException;
}
