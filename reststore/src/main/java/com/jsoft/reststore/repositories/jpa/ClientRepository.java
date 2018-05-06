package com.jsoft.reststore.repositories.jpa;

import com.jsoft.reststore.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface ClientRepository extends CrudRepository<Client, Long> {

    Client findByClientUserAndPassword(String usuer, String password);

    Client findByEmail(String email);

    Client findByDocument(BigDecimal document);

}
