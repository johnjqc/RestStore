package com.jsoft.reststore.repositories.jpa;

import com.jsoft.reststore.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * The persistence operations repository for {@link Product}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findByBarcode(String barcode);
}
