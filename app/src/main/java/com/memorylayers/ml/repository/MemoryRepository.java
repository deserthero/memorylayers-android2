package com.memorylayers.ml.repository;

import com.memorylayers.ml.model.Memory;
import com.memorylayers.ml.repository.IRepository.IMemoryRepository;


/**
 * Created by ahmed.marzouk on 4/23/2016.
 */
public class MemoryRepository implements IMemoryRepository {
    @Override
    public Memory GetMemoriesByOwnerId(String ownerId) {
        return null;
    }

    @Override
    public long Insert(Memory entity) {
        return 0;
    }

    @Override
    public Memory GetByID(long ID) {
        return null;
    }

    @Override
    public Iterable<Memory> GetAll() {
        return null;
    }

    @Override
    public Memory Modify(Memory entity) {
        return null;
    }

    @Override
    public boolean Delete(long ID) {
        return false;
    }
}
