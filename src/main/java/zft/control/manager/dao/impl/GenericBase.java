package zft.control.manager.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import zft.control.manager.dao.GenericDao;

import java.io.Serializable;
import java.util.List;

public abstract class GenericBase<T, PK extends Serializable> implements GenericDao<T, PK> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected abstract Class<?> getClasses();

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public T load(PK id) throws Exception {
        return (T) this.getCurrentSession().load(getClasses(), id);
    }

    @Override
    public T get(PK id) throws Exception {
        return (T) this.getCurrentSession().get(getClasses(), id);
    }

    @Override
    public List<T> findAll() throws Exception {
        List<T> data = this.getCurrentSession().createQuery("from " + getClasses().getName()).list();
        return data;
    }

    @Override
    public void persist(T entity) throws Exception {
        this.getCurrentSession().persist(entity);
    }

    @Override
    public void update(T entity) throws Exception {
        this.getCurrentSession().update(entity);
    }

    @Override
    public PK save(T entity) throws Exception {
        return (PK) this.getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) throws Exception {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(PK id) throws Exception {
        T entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    @Override
    public void delete(T entity) throws Exception {
        this.getCurrentSession().delete(entity);
    }

    @Override
    public void flush() throws Exception {
        this.getCurrentSession().flush();
    }

}
