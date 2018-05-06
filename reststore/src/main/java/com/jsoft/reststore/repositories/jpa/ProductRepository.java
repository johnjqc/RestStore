package com.jsoft.reststore.repositories.jpa;

import com.jsoft.reststore.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}
