package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Inventory;
import com.jsoft.reststore.repositories.jpa.InventoryRespository;
import com.jsoft.reststore.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InventoryService implements IInventoryService {

    @Autowired
    private InventoryRespository inventoryRespository;

    @Override
    public Inventory save(Inventory inventory) {
        return null;
    }

    @Override
    public List<Inventory> findAll() {
        return StreamSupport.stream(inventoryRespository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
