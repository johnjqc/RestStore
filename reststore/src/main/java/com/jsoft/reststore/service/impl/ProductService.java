package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Product;
import com.jsoft.reststore.repositories.jpa.ProductRepository;
import com.jsoft.reststore.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<ProductRepository, Product> implements IProductService {

}
