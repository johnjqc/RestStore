package com.jsoft.reststore.service;

import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.impl.LoginService;

/**
 * The interface for {@link LoginService}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface ILoginService {

    Client login(String user, String password) throws StoreApiException;

}
