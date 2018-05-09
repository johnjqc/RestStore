package com.jsoft.reststore.service;

import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.impl.ClientService;

import java.math.BigDecimal;

/**
 * The interface for {@link ClientService}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface IClientService extends IGenericService<Client> {

    /**
     * Find a Client by user and password
     *
     * @param user the user
     * @param password the password
     * @return the Client found
     */
    Client findByUserAndPassword(String user, String password) throws StoreApiException;

    /**
     * Find a Client by email
     *
     * @param email the email
     * @return the client found
     */
    Client findByEmail(String email);

    /**
     * Find a Client by document
     *
     * @param document the document
     * @return the Client found
     */
    Client findByDocument(BigDecimal document);
}
