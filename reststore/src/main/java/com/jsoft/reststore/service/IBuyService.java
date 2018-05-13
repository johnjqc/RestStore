package com.jsoft.reststore.service;

import com.jsoft.reststore.model.Buy;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.impl.BuyService;

/**
 * The interface for {@link BuyService}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface IBuyService {

    Buy buy() throws StoreApiException;

}
