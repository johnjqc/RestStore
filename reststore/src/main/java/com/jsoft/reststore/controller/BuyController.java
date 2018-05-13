package com.jsoft.reststore.controller;

import com.jsoft.reststore.model.Buy;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.model.converter.BuyConverter;
import com.jsoft.reststore.model.web.BuyResponse;
import com.jsoft.reststore.model.web.BuyViewRequest;
import com.jsoft.reststore.model.web.BuyViewResponse;
import com.jsoft.reststore.service.IBuyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping(path = "/buy")
public class BuyController  extends AbstractController {

    /**
     * The {@link ClientController} logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BuyController.class);

    private IBuyService buyService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<BuyResponse> buy(@Valid @RequestBody BuyViewRequest buyRequest) {
        BuyResponse apiResponse = new BuyResponse();
        ResponseEntity<BuyResponse> httpResponse = new ResponseEntity<>(apiResponse, HttpStatus.FOUND);

        logger.debug("Query all Clients");

        try {
            Buy buy = buyService.buy();
            apiResponse.setBuy(BuyConverter.domainToWeb(buy));

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
