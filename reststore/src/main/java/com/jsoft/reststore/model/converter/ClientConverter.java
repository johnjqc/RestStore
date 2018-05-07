package com.jsoft.reststore.model.converter;

import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.model.web.ClientView;

/**
 * Utility class to convert {@link Client} between web and domain.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public final class ClientConverter {

    // The private constructor by utility class
    private ClientConverter() {}

    /**
     * Converts a domain layer Client to a web layer Client
     *
     * @param client
     *            the domain {@link Client}
     * @return the web {@link ClientView}
     */
    public static ClientView domainToWeb(Client client) {
        ClientView result = new ClientView();

        result.setClientId(client.getClientId());
        result.setClientName(client.getClientName());
        result.setDocument(client.getDocument());
        result.setAge(client.getAge());
        result.setEmail(client.getEmail());
        result.setClientUser(client.getClientUser());
        result.setPassword(client.getPassword());

        return result;
    }

    /**
     * Converts a web layer Client to a domain layer Client
     *
     * @param client
     *            the web {@link ClientView}
     * @return the domain {@link Client}
     */
    public static Client webToDomain(ClientView client) {
        Client result = new Client();

        result.setClientId(client.getClientId());
        result.setClientName(client.getClientName());
        result.setDocument(client.getDocument());
        result.setAge(client.getAge());
        result.setEmail(client.getEmail());
        result.setClientUser(client.getClientUser());
        result.setPassword(client.getPassword());

        return result;
    }
}
