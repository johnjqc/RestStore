package com.jsoft.reststore.service;

import com.jsoft.reststore.model.Client;

import java.math.BigDecimal;

public interface IClientService extends IGenericService<Client> {

    Client findByUserAndPassword(String user, String password);

    Client findByEmail(String email);

    Client findByDocument(BigDecimal document);
}
