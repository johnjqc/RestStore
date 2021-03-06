package com.jsoft.reststore.service;

import com.jsoft.reststore.model.Product;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.impl.ProductService;

/**
 * The interface for {@link ProductService}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface IProductService extends IGenericService<Product> {

    /**
     * Find a product by barcode
     * @param barcode the barcode
     * @return the product
     * @throws StoreApiException
     */
    Product findByBarcode(String barcode) throws StoreApiException;
}
