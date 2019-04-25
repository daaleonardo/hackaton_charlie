package org.academiadecodigo.charlie.persistence.dao.jpa;

import org.academiadecodigo.charlie.persistence.dao.Dao;
import org.academiadecodigo.charlie.persistence.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericDao<T extends Model> implements Dao<T> {

    protected Class<T> modelType;

    @PersistenceContext
    protected EntityManager manager;

    public GenericDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> criteriaQuery = manager.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);
        return manager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T findById(Integer id) {
        return manager.find(modelType, id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {
        return manager.merge(modelObject);
    }

    @Override
    public void delete(Integer id) {
        manager.remove(manager.find(modelType, id));
    }

}
