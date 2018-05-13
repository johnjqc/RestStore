package com.jsoft.reststore.repositories.jpa;

import com.jsoft.reststore.model.Buy;
import org.springframework.data.repository.CrudRepository;

/**
 * The persistence operations repository for {@link Buy}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface BuyRepository extends CrudRepository<Buy, Long> {
}
