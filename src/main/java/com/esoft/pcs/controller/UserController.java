package com.esoft.pcs.controller;

import com.esoft.pcs.models.User;
import com.esoft.pcs.repository.UserRepository;
import com.esoft.pcs.service.UserSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserSrvice userSrvice;

    @PostMapping
    public @ResponseBody User createNewUser (@RequestBody User userInputDto) {
        return userSrvice.createUser(userInputDto);
    }

    @GetMapping
    public @ResponseBody List<User> getAllUsers() {
        return userSrvice.getAllUsers();
    }

    @GetMapping("/{id}")
    public @ResponseBody User getUserById(@PathVariable(value = "id") Integer userId) throws Exception{
        return userSrvice.getUserById(userId);
    }

    @PutMapping
    public @ResponseBody User updateUser (@RequestBody User userInputDto) {
        return userSrvice.updateUser(userInputDto);
    }

    @DeleteMapping
    public @ResponseBody boolean deleteUser (@RequestBody User userInputDto) {
        return userSrvice.deleteUser(userInputDto);
    }


}
