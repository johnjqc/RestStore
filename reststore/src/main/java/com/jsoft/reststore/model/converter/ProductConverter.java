package com.jsoft.reststore.model.converter;

import com.jsoft.reststore.model.Product;
import com.jsoft.reststore.model.web.ProductView;

public final class ProductConverter {

    // The private constructor by utility class
    private ProductConverter(){}

    public static ProductView webToDomain(Product product) {
        ProductView result = new ProductView();

        result.setProductId(product.getProductId());
        result.setProductName(product.getProductName());
        result.setCost(product.getCost());
        result.setBarcode(product.getBarcode());
        result.setDescription(product.getDescription());

        return result;
    }

    public static Product domainToWeb(ProductView product) {
        Product result = new Product();

        result.setProductId(product.getProductId());
        result.setProductName(product.getProductName());
        result.setCost(product.getCost());
        result.setBarcode(product.getBarcode());
        result.setDescription(product.getDescription());

        return result;
    }
}
