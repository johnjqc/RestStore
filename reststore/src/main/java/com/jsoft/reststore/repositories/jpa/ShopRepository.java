package com.jsoft.reststore.repositories.jpa;

import com.jsoft.reststore.model.Shop;
import org.springframework.data.repository.CrudRepository;

/**
 * The persistence operations repository for {@link Shop}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface ShopRepository extends CrudRepository<Shop, Long> {

}
