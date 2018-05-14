package com.jsoft.reststore.repositories.jpa;

import com.jsoft.reststore.model.Inventory;
import com.jsoft.reststore.model.Product;
import com.jsoft.reststore.model.Shop;
import org.springframework.data.repository.CrudRepository;

/**
 * The persistence operations repository for {@link Inventory}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    /**
     * Find a inventory by product and shop
     * @param product the product
     * @param shop th shop
     * @return the inventory
     */
    Inventory findByProductAndShop(Product product, Shop shop);

}
