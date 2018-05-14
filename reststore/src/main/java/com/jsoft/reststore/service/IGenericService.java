package com.jsoft.reststore.service;

import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.impl.AbstractService;

import java.util.List;

/**
 * The interface for {@link AbstractService}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface IGenericService<J> {

    /**
     * Save an entity
     *
     * @param j the entity
     * @return the saved entity
     * @throws StoreApiException
     */
    J save(J j) throws StoreApiException;

    /**
     * Find all items
     * @return the list of  entities
     * @throws StoreApiException
     */
    List<J> findAll() throws StoreApiException;

    /**
     * Delete by Id entity
     * @param id the id
     * @throws StoreApiException
     */
    void deleteById(Long id) throws StoreApiException;

}
