package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.repositories.jpa.ClientRepository;
import com.jsoft.reststore.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {

        return StreamSupport.stream(clientRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Client save(Client client) {

        return clientRepository.save(client);
    }

    @Override
    public boolean deleteById(Long id) {
        clientRepository.deleteById(id);
        return true;
    }

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
