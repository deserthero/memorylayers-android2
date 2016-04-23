package com.memorylayers.ml.repository;

import com.memorylayers.ml.model.User;
import com.memorylayers.ml.repository.IRepository.IUserRepository;

/**
 * Created by ahmed.marzouk on 4/23/2016.
 */
public class UserRepository implements IUserRepository {
    @Override
    public boolean IsExist(String email, String Password) {
        return false;
    }

    @Override
    public boolean IsEmailExists(String email) {
        return false;
    }

    @Override
    public User GetUserByEmail(String email) {
        return null;
    }

    @Override
    public long Insert(User entity) {
        return 0;
    }

    @Override
    public User GetByID(long ID) {
        return null;
    }

    @Override
    public Iterable<User> GetAll() {
        return null;
    }

    @Override
    public User Modify(User entity) {
        return null;
    }

    @Override
    public boolean Delete(long ID) {
        return false;
    }
}
