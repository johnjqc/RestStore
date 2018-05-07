package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.repositories.jpa.ClientRepository;
import com.jsoft.reststore.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * The service implementation for client operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Service
public class ClientService extends AbstractService<ClientRepository, Client> implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findByUserAndPassword(String user, String password) {

        return clientRepository.findByClientUserAndPassword(user, password);
    }

    @Override
    public Client findByEmail(String email) {

        return clientRepository.findByEmail(email);
    }

    @Override
    public Client findByDocument(BigDecimal document) {

        return clientRepository.findByDocument(document);
    }
}
