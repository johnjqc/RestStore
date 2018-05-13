package com.jsoft.reststore.repositories.jpa;

import com.jsoft.reststore.model.Invoice;
import org.springframework.data.repository.CrudRepository;

/**
 * The persistence operations repository for {@link Invoice}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
