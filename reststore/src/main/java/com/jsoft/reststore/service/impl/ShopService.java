package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Shop;
import com.jsoft.reststore.repositories.jpa.ShopRepository;
import com.jsoft.reststore.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShopService implements IShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Shop save(Shop shop) {
        return null;
    }

    @Override
    public List<Shop> findAll() {
        return StreamSupport.stream(shopRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
