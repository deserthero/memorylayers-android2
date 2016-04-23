package com.memorylayers.ml.repository.IRepository;

/**
 * Created by ahmed.marzouk on 4/23/2016.
 */
public interface IRepository<E> {
    long Insert(E entity);
    E GetByID(long ID);
    Iterable<E> GetAll();
    E Modify(E entity);
    boolean Delete(long ID);
}

