package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Product;
import com.jsoft.reststore.repositories.jpa.ProductRepository;
import com.jsoft.reststore.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * The service implementation for product operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Service
public class ProductService extends AbstractService<ProductRepository, Product> implements IProductService {

}
