package com.esoft.pcs.service;

import com.esoft.pcs.models.User;
import java.util.List;

public interface UserSrvice {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id) throws Exception;

    boolean deleteUser(User user);

    User updateUser(User user);
}
