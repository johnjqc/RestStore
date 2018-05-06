package com.jsoft.reststore.controller;

import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.model.converter.ClientConverter;
import com.jsoft.reststore.model.web.ClientResponse;
import com.jsoft.reststore.model.web.ClientView;
import com.jsoft.reststore.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/clients")
public class ClientController {

    /**
     * The {@link ClientController} logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private IClientService clientService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ClientResponse> queryAll() {
        ClientResponse apiResponse = new ClientResponse();
        ResponseEntity<ClientResponse> httpResponse = new ResponseEntity<>(apiResponse,
                HttpStatus.OK);

        logger.info("Query all Clients");

        List<Client> list = clientService.findAll();

        if (!list.isEmpty()) {
            apiResponse.setClients(list.stream()
                    .map(ClientConverter::webToDomain)
                    .collect(Collectors.toList()));
        }

        return httpResponse;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ClientResponse> createClient(@Valid @RequestBody ClientView client) {
        ClientResponse apiResponse = new ClientResponse();
        ResponseEntity<ClientResponse> httpResponse = new ResponseEntity<>(apiResponse,
                HttpStatus.CREATED);

        Client createdClient = clientService.save(ClientConverter.domainToWeb(client));
        apiResponse.setClient(ClientConverter.webToDomain(createdClient));

        return httpResponse;
    }
}
