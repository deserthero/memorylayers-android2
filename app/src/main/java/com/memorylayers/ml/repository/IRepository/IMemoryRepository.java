package com.memorylayers.ml.repository.IRepository;

import com.memorylayers.ml.model.Memory;
import com.memorylayers.ml.model.User;

/**
 * Created by ahmed.marzouk on 4/23/2016.
 */
public interface IMemoryRepository extends IRepository<Memory> {

    Memory GetMemoriesByOwnerId(String ownerId);
}
