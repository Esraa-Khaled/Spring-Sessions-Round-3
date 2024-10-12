package com.ntg.data.configurations;

import java.util.List;

public interface CustomCrudOperations<T, ID> {

    List<T> getAll() throws Exception;

    void save(T entity) throws Exception;

    T getById(ID id) throws Exception;
}
