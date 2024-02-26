package com.inventory.inventory.controller;


import com.inventory.inventory.exception.ResourceNotFoundException;
import com.inventory.inventory.model.UserInfo;
import com.inventory.inventory.repository.UserInfoRepository;
import com.inventory.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserInfo getUser(@PathVariable String id){
        return userService.getUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }

    @PostMapping
    public UserInfo addNewUser(@RequestBody UserInfo userInfo){
        return userService.addUser(userInfo);
    }



}
