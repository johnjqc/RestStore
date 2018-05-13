package com.jsoft.reststore.service;

import com.jsoft.reststore.model.Invoice;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.impl.BuyService;

import java.util.Map;

/**
 * The interface for {@link BuyService}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface IBuyService {

    Invoice buy(String user, String password, Long shopId, Map<String, Integer> productList) throws StoreApiException;

}
