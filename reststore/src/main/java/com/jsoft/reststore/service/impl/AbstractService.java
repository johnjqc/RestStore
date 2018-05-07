package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.common.ApiResponseCode;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * The service implementation for generic operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public abstract class AbstractService<T extends CrudRepository, J> implements IGenericService<J> {

    /** The repository defined on type T for manage persitence operations */
    @Autowired
    private T repository;

    @Override
    public J save(J j) throws StoreApiException {
        try {
            return (J)repository.save(j);
        } catch (Exception e) {
            throw new StoreApiException(ApiResponseCode.ERROR_ON_DATABASE_STORE, e);
        }
    }

    @Override
    public List<J> findAll() throws StoreApiException {
        try {
            return (List<J>)StreamSupport.stream(repository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new StoreApiException(ApiResponseCode.ERROR_ON_DATABASE_QUERY, e);
        }
    }

    @Override
    public void deleteById(Long id) throws StoreApiException {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new StoreApiException(ApiResponseCode.ERROR_ON_DATABASE_DELETE, e);
        }
    }

}
