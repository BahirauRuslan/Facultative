package by.bntu.fitr.povt.bahirauruslan.facultative.models.dao;

import java.util.List;

public interface IDao<T, K> {
    List<T> getAll();
    T get(K key);
    boolean add(T entity);
    boolean delete(T entity);
    boolean update(T entity);
}
