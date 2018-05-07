package com.jsoft.reststore.service;

import com.jsoft.reststore.service.impl.AbstractService;

import java.util.List;

/**
 * The interface for {@link AbstractService}
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public interface IGenericService<J> {

    J save(J j);

    List<J> findAll();

    boolean deleteById(Long id);

}
