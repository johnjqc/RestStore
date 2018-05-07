package com.jsoft.reststore.model.converter;

import com.jsoft.reststore.model.Product;
import com.jsoft.reststore.model.Shop;
import com.jsoft.reststore.model.web.ProductView;
import com.jsoft.reststore.model.web.ShopView;

/**
 * Utility class to convert {@link Product} between web and domain.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public final class ProductConverter {

    // The private constructor by utility class
    private ProductConverter(){}

    /**
     * Converts a domain layer Product to a web layer Product
     *
     * @param product
     *            the domain {@link Product}
     * @return the web {@link ProductView}
     */
    public static ProductView domainToWeb(Product product) {
        ProductView result = new ProductView();

        result.setProductId(product.getProductId());
        result.setProductName(product.getProductName());
        result.setCost(product.getCost());
        result.setBarcode(product.getBarcode());
        result.setDescription(product.getDescription());

        return result;
    }

    /**
     * Converts a web layer Product to a domain layer Product
     *
     * @param product
     *            the web {@link ProductView}
     * @return the domain {@link Product}
     */
    public static Product webToDomain(ProductView product) {
        Product result = new Product();

        result.setProductId(product.getProductId());
        result.setProductName(product.getProductName());
        result.setCost(product.getCost());
        result.setBarcode(product.getBarcode());
        result.setDescription(product.getDescription());

        return result;
    }
}
