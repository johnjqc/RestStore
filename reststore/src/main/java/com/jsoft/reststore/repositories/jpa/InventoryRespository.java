package com.jsoft.reststore.repositories.jpa;

import com.jsoft.reststore.model.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRespository extends CrudRepository<Inventory, Long> {
}
