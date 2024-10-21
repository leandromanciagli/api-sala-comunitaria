package com.example.jyaa2024_grupo10.dao;

import java.util.List;

public interface IGenericDAO<T, ID> {
    List<T> findAll();
    T find(ID Id);
    T create(T entity);
    T update(T entity);
    T delete(T entity);
}
