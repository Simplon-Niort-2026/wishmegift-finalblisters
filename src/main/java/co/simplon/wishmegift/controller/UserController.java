package co.simplon.wishmegift.controller;

import co.simplon.wishmegift.entity.UserEntity;
import co.simplon.wishmegift.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public UserEntity save(@RequestBody UserEntity user) {
        return userService.save(user);
    }
}
