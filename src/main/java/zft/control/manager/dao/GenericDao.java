package zft.control.manager.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Dao通用接口
 */

public interface GenericDao<T, PK extends Serializable> {

    T load(PK id) throws Exception;

    T get(PK id) throws Exception;

    List<T> findAll() throws Exception;

    void persist(T entity) throws Exception;

    void update(T entity) throws Exception;

    PK save(T entity) throws Exception;

    void saveOrUpdate(T entity) throws Exception;

    void delete(PK id) throws Exception;

    void delete(T entity) throws Exception;

    void flush() throws Exception;

}
