package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Buy;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.repositories.jpa.BuyRepository;
import com.jsoft.reststore.service.IBuyService;

public class BuyService extends AbstractService<BuyRepository, Buy> implements IBuyService {

    @Override
    public Buy buy() throws StoreApiException {
        return null;
    }
}
