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

    /**
     * Process of buy order
     *
     * @param user the user
     * @param password the password
     * @param shopId the shop id of buy
     * @param productList the product list of buy
     * @return the Generated invoice
     * @throws StoreApiException
     */
    Invoice buy(String user, String password, Long shopId, Map<String, Integer> productList) throws StoreApiException;

}
