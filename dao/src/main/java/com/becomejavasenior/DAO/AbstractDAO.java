package com.becomejavasenior.DAO;

import java.util.List;

public interface AbstractDAO<T> {

    T create(T entity);

    T update(T entity);

    void delete(Integer id);

    T getById(Integer id);

    List<T> getAll();
}
