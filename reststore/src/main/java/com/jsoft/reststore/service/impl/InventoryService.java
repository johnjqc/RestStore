package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Inventory;
import com.jsoft.reststore.repositories.jpa.InventoryRespository;
import com.jsoft.reststore.service.IInventoryService;
import org.springframework.stereotype.Service;

@Service
public class InventoryService extends AbstractService<InventoryRespository, Inventory> implements IInventoryService {


}
