package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Shop;
import com.jsoft.reststore.model.common.ApiResponseCode;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.repositories.jpa.ShopRepository;
import com.jsoft.reststore.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The service implementation for shop operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Service
public class ShopService extends AbstractService<ShopRepository, Shop> implements IShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Shop findById(Long shopId) throws StoreApiException {

        return shopRepository.findById(shopId)
                .orElseThrow(() -> new StoreApiException(ApiResponseCode.SHOP_NOT_FOUND, "Shop ID not exist: " + shopId));
    }
}
