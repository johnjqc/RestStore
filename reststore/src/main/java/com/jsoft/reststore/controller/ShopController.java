package com.jsoft.reststore.controller;

import com.jsoft.reststore.model.Shop;
import com.jsoft.reststore.model.converter.ShopConverter;
import com.jsoft.reststore.model.web.ShopResponse;
import com.jsoft.reststore.model.web.ShopView;
import com.jsoft.reststore.service.IShopService;
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
@RequestMapping(path = "/shop")
public class ShopController {

    /**
     * The {@link ShopController} logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private IShopService shopService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ShopResponse> queryAll() {
        ShopResponse apiResponse = new ShopResponse();
        ResponseEntity<ShopResponse> httpResponse = new ResponseEntity<>(apiResponse,
                HttpStatus.FOUND);

        logger.debug("Query all Shops");

        List<Shop> list = shopService.findAll();

        if (!list.isEmpty()) {
            apiResponse.setShopList(list.stream()
                    .map(ShopConverter::webToDomain)
                    .collect(Collectors.toList()));
        }

        return httpResponse;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ShopResponse> createShop(@Valid @RequestBody ShopView shop) {
        ShopResponse apiResponse = new ShopResponse();
        ResponseEntity<ShopResponse> httpResponse = new ResponseEntity<>(apiResponse,
                HttpStatus.CREATED);

        Shop createdShop = shopService.save(ShopConverter.domainToWeb(shop));
        apiResponse.setShop(ShopConverter.webToDomain(createdShop));

        return httpResponse;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<ShopResponse> deleteShop(@PathVariable("id") Long id) {
        ShopResponse apiResponse = new ShopResponse();
        ResponseEntity<ShopResponse> httpResponse = new ResponseEntity<>(apiResponse, HttpStatus.OK);

        shopService.deleteById(id);

        return httpResponse;
    }
}
