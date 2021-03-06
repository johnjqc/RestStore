package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Inventory;
import com.jsoft.reststore.model.Product;
import com.jsoft.reststore.model.Shop;
import com.jsoft.reststore.model.common.ApiResponseCode;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.repositories.jpa.InventoryRepository;
import com.jsoft.reststore.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The service implementation for inventory operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Service
public class InventoryService extends AbstractService<InventoryRepository, Inventory> implements IInventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory findByProductAndShop(Product product, Shop shop) throws StoreApiException {
        Inventory inventory = inventoryRepository.findByProductAndShop(product, shop);

        if (inventory == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Inventory not exist for shop: ");
            sb.append(shop.getShopId());
            sb.append(" and product: ");
            sb.append(product.getProductName());

            throw new StoreApiException(ApiResponseCode.INVENTORY_NOT_FOUND,  sb.toString());
        }
        return inventory;
    }
}
