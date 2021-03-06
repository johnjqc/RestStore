package com.jsoft.reststore.service;

import com.jsoft.reststore.model.Inventory;
import com.jsoft.reststore.model.Product;
import com.jsoft.reststore.model.Shop;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.impl.InventoryService;

/**
 * The interface for {@link InventoryService}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface IInventoryService extends IGenericService<Inventory> {

    /**
     * Find a inventory by product and shop
     * @param product the product
     * @param shop th shop
     * @return the inventory
     * @throws StoreApiException
     */
    Inventory findByProductAndShop(Product product, Shop shop) throws StoreApiException;
}
