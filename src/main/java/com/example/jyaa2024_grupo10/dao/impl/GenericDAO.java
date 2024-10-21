package com.example.jyaa2024_grupo10.dao.impl;

import com.example.jyaa2024_grupo10.dao.IGenericDAO;
import com.example.jyaa2024_grupo10.model.EntityManagerFactoryInstance;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericDAO<T, ID> implements IGenericDAO<T, ID> {

    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> findAll() {
        EntityManager em = null;
        try {
            em = EntityManagerFactoryInstance.getInstance().createEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(this.entityClass);
            Root<T> root = cq.from(this.entityClass);

            // Verifica si la entidad tiene el atributo "fechaHasta"
            boolean hasFechaHasta = false;
            try {
                this.entityClass.getDeclaredField("fechaHasta");
                hasFechaHasta = true;
            } catch (NoSuchFieldException e) {
                hasFechaHasta = false;
            }

            if (hasFechaHasta) {
                cq.select(root).where(cb.isNull(root.get("fechaHasta")));
            } else {
                cq.select(root);
            }

            return em.createQuery(cq).getResultList();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }


    @Override
    public T find(ID id) {
        EntityManager em = null;
        try {
            em = EntityManagerFactoryInstance.getInstance().createEntityManager();
            return em.find(this.entityClass, id);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public T create(T entity) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = EntityManagerFactoryInstance.getInstance().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            em.persist(entity);
            em.flush();
            em.refresh(entity);

            transaction.commit();
            return entity;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public T update(T entity) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = EntityManagerFactoryInstance.getInstance().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            T updatedEntity = em.merge(entity);
            em.flush();

            transaction.commit();
            return updatedEntity;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public T delete(T entity) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = EntityManagerFactoryInstance.getInstance().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            // Si la entidad está detached, vuelve a unirla al contexto de persistencia
            if (!em.contains(entity)) {
                entity = em.merge(entity);
            }
            em.remove(entity);
            em.flush();
            transaction.commit();

            return entity;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
