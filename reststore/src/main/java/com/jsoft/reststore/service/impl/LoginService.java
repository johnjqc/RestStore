package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.model.common.ApiResponseCode;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.IClientService;
import com.jsoft.reststore.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The service implementation for login operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    private IClientService clientService;

    @Override
    public Client login(String user, String password) throws StoreApiException {

        Client client = clientService.findByUserAndPassword(user, password);

        if (client == null) {
            throw new StoreApiException(ApiResponseCode.LOGIN_FAIL);
        } else {
            return client;
        }
    }
}
