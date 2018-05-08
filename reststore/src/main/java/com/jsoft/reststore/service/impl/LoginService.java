package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.ILoginService;
import org.springframework.stereotype.Service;

/**
 * The service implementation for login operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Service
public class LoginService implements ILoginService {

    @Override
    public void login(String user, String password) throws StoreApiException {

    }
}
