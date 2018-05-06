package com.jsoft.reststore.model.converter;

import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.model.web.ClientView;

public final class ClientConverter {

    // The private constructor by utility class
    private ClientConverter() {}

    public static ClientView webToDomain(Client client) {
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

    public static Client domainToWeb(ClientView clinet) {
        Client result = new Client();

        result.setClientId(clinet.getClientId());
        result.setClientName(clinet.getClientName());
        result.setDocument(clinet.getDocument());
        result.setAge(clinet.getAge());
        result.setEmail(clinet.getEmail());
        result.setClientUser(clinet.getClientUser());
        result.setPassword(clinet.getPassword());

        return result;
    }
}
