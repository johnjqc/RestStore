package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Shop;
import com.jsoft.reststore.repositories.jpa.ShopRepository;
import com.jsoft.reststore.service.IShopService;
import org.springframework.stereotype.Service;

/**
 * The service implementation for shop operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Service
public class ShopService extends AbstractService<ShopRepository, Shop> implements IShopService {

}
