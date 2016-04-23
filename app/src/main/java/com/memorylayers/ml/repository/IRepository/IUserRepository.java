package com.memorylayers.ml.repository.IRepository;

import com.memorylayers.ml.model.User;

/**
 * Created by ahmed.marzouk on 4/23/2016.
 */
public interface IUserRepository extends IRepository<User> {

    boolean IsExist(String email, String Password);

    boolean IsEmailExists(String email);

    User GetUserByEmail(String email);

}
