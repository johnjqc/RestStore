package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Inventory;
import com.jsoft.reststore.repositories.jpa.InventoryRepository;
import com.jsoft.reststore.service.IInventoryService;
import org.springframework.stereotype.Service;

/**
 * The service implementation for inventory operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Service
public class InventoryService extends AbstractService<InventoryRepository, Inventory> implements IInventoryService {


}
