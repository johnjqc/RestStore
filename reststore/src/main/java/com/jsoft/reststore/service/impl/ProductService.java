package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Product;
import com.jsoft.reststore.model.common.ApiResponseCode;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.repositories.jpa.ProductRepository;
import com.jsoft.reststore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The service implementation for product operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Service
public class ProductService extends AbstractService<ProductRepository, Product> implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findByBarcode(String barcode) throws StoreApiException {

        Product product = productRepository.findByBarcode(barcode);

        if (product == null) {
            throw new StoreApiException(ApiResponseCode.PRODUCT_NOT_FOUND, "Product Barcode not exist: " + barcode);
        }
        return product;
    }
}
