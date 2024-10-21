package com.example.jyaa2024_grupo10.dao.impl;

import com.example.jyaa2024_grupo10.dao.IGenericDAO;
import org.glassfish.hk2.api.Factory;

public class GenericDAOFactory<T, K> implements Factory<IGenericDAO<T, K>> {
    private final Class<T> entityClass;
    private final Class<K> keyClass;

    public GenericDAOFactory(Class<T> entityClass, Class<K> keyClass) {
        this.entityClass = entityClass;
        this.keyClass = keyClass;
    }

    @Override
    public IGenericDAO<T, K> provide() {
        return new GenericDAO<>(entityClass);
    }

    @Override
    public void dispose(IGenericDAO<T, K> instance) {
        // Cleanup if necessary
    }
}
