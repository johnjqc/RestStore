package com.jsoft.reststore.controller;

import com.jsoft.reststore.model.Invoice;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.model.web.BuyResponse;
import com.jsoft.reststore.model.web.BuyRequest;
import com.jsoft.reststore.service.IBuyService;
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


@Controller
@RequestMapping(path = "/buy")
public class BuyController  extends AbstractController {

    /**
     * The {@link ClientController} logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BuyController.class);

    @Autowired
    private IBuyService buyService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<BuyResponse> buy(@Valid @RequestBody BuyRequest buyRequest) {
        BuyResponse apiResponse = new BuyResponse();
        ResponseEntity<BuyResponse> httpResponse = new ResponseEntity<>(apiResponse, HttpStatus.FOUND);

        try {
            Invoice invoice = buyService.buy(buyRequest.getUser(), buyRequest.getPassword(), buyRequest.getShopId(),
                    buyRequest.getProduct());
//            BuyView buyResponse = BuyConverter.domainToWeb(buy);
//            apiResponse.setBuy(buyResponse);

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
