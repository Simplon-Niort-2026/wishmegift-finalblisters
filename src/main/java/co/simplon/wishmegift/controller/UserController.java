package co.simplon.wishmegift.controller;

import co.simplon.wishmegift.entity.UserEntity;
import co.simplon.wishmegift.service.UserService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping()
    public ResponseEntity<@NonNull Object> save(@Validated @RequestBody UserEntity user) {

         UserEntity userCreated =  userService.save(user);
         return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }


    @PostMapping("/user")
    public UserEntity find(@RequestBody UserEntity user) {
        return userService.find(user);
    }
}
