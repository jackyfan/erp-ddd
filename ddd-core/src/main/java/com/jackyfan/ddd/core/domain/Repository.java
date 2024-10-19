package com.jackyfan.ddd.core.domain;

import org.hibernate.Criteria;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * 资源库接口
 */
public interface Repository<E extends AggregateRoot, ID extends Identity> {
    Optional<E> findById(ID id);
    List<E> findAll();
    List<E> findAllMatching(Criteria criteria);
    boolean exists(ID id);
    void save(E entity);
    void saveAll(Collection<? extends E> entities);
    void delete(E entity);
    void deleteAll();
    void deleteAll(Collection<? extends E> entities);
    void deleteAllMatching(Criteria criteria);
}
