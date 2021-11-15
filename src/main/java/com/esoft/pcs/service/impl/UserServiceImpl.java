package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.User;
import com.esoft.pcs.repository.UserRepository;
import com.esoft.pcs.service.UserSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserSrvice {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) throws Exception {
        return userRepository.findById(id).
                orElseThrow(() -> new Exception("User not found for id=" + id));
    }

    @Override
    public boolean deleteUser(User user) {
        userRepository.delete(user);
        return true;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
