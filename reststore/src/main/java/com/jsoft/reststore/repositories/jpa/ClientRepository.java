package com.jsoft.reststore.repositories.jpa;

import com.jsoft.reststore.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

/**
 * The persistence operations repository for {@link Client}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface ClientRepository extends CrudRepository<Client, Long> {

    /**
     * Find a Client by user and password
     *
     * @param user the user
     * @param password the password
     * @return the Client found
     */
    Client findByClientUserAndPassword(String user, String password);

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
