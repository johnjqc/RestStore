package com.jsoft.reststore.controller;

import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.model.common.ApiResponseCode;
import com.jsoft.reststore.model.common.StoreApiException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/client")
public class ClientController extends AbstractController {

    /**
     * The {@link ClientController} logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private IClientService clientService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ClientResponse> queryAll() {
        ClientResponse apiResponse = new ClientResponse();
        ResponseEntity<ClientResponse> httpResponse = new ResponseEntity<>(apiResponse, HttpStatus.FOUND);

        logger.debug("Query all Clients");

        try {
            List<Client> list = clientService.findAll();

            if (!list.isEmpty()) {
                apiResponse.setClientList(list.stream()
                        .map(ClientConverter::domainToWeb)
                        .collect(Collectors.toList()));
                apiResponse.setApiResponseCode(ApiResponseCode.SUCCESS);
            }
        } catch (StoreApiException e) {
            handleException(e, apiResponse);
        }

        return httpResponse;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ClientResponse> createClient(@Valid @RequestBody ClientView client) {
        ClientResponse apiResponse = new ClientResponse();
        ResponseEntity<ClientResponse> httpResponse = new ResponseEntity<>(apiResponse, HttpStatus.CREATED);

        try {
            Client createdClient = clientService.save(ClientConverter.webToDomain(client));
            apiResponse.setClient(ClientConverter.domainToWeb(createdClient));

            if (client.getClientId() == null) {
                apiResponse.setApiResponseCode(ApiResponseCode.CLIENT_CREATED);
            } else {
                apiResponse.setApiResponseCode(ApiResponseCode.CLIENT_UPDATED);
            }

        } catch (StoreApiException e) {
            handleException(e, apiResponse);
        }

        return httpResponse;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClientResponse> deleteClient(@PathVariable("id") Long id) {
        ClientResponse apiResponse = new ClientResponse();
        ResponseEntity<ClientResponse> httpResponse = new ResponseEntity<>(apiResponse, HttpStatus.OK);

        try {
            clientService.deleteById(id);
            apiResponse.setApiResponseCode(ApiResponseCode.CLIENT_DELETED);

        } catch (StoreApiException e) {
            handleException(e, apiResponse);
        }

        return httpResponse;
    }

    @Override
    Logger getLogger() {
        return logger;
    }
}
