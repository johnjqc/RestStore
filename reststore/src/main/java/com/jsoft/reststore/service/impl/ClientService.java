package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.controller.ClientController;
import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.repositories.jpa.ClientRepository;
import com.jsoft.reststore.service.IClientService;
import com.jsoft.reststore.service.ISecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * The service implementation for client operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Service
public class ClientService extends AbstractService<ClientRepository, Client> implements IClientService {

    /**
     * The {@link ClientController} logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ISecurityService securityService;

    @Override
    public Client save(Client client) throws StoreApiException {

        logger.debug("Save client: {}", client.getDocument());

        if (client.getClientId() == null) {
            client.setPassword(securityService.encryptData(client.getPassword()));
        } else {
            Optional<Client> storedOptionalClient = clientRepository.findById(client.getClientId());
            if (storedOptionalClient.isPresent() &&
                    !storedOptionalClient.get().getPassword().equals(client.getPassword())) {
                client.setPassword(securityService.encryptData(client.getPassword()));
            } else {
                logger.info("The password is not updated on save client");
            }
        }

        return super.save(client);
    }

    @Override
    public Client findByUserAndPassword(String user, String password) throws StoreApiException {

        logger.debug("Find client by user: {}", user);
        return clientRepository.findByClientUserAndPassword(user, securityService.encryptData(password));
    }

    @Override
    public Client findByEmail(String email) {

        logger.debug("Find client by email: {}", email);
        return clientRepository.findByEmail(email);
    }

    @Override
    public Client findByDocument(BigDecimal document) {

        logger.debug("Find client by document: {}", document);
        return clientRepository.findByDocument(document);
    }
}
