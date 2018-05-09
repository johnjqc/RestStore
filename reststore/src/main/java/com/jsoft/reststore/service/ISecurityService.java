package com.jsoft.reststore.service;

import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.impl.SecurityService;

/**
 * The interface for {@link SecurityService}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface ISecurityService {

    /**
     * Generate secure encryption process
     * @param data the data to encrypt
     * @return the encrypted data
     * @throws StoreApiException if encrypt process fail
     */
    String encryptData(String data) throws StoreApiException;

}
