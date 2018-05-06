package com.jsoft.reststore.service;

import java.util.List;

public interface IGenericService<J> {

    J save(J j);

    List<J> findAll();

    boolean deleteById(Long id);

}
