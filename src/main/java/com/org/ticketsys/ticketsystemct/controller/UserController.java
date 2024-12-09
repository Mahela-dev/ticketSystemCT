package com.org.ticketsys.ticketsystemct.controller;
import com.org.ticketsys.ticketsystemct.domian.UserDetails;
import com.org.ticketsys.ticketsystemct.exception.TSException;
import com.org.ticketsys.ticketsystemct.repositery.UserDao;
import com.org.ticketsys.ticketsystemct.resources.UserResources;
import com.org.ticketsys.ticketsystemct.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/customer")
public class UserController {
    private UserService customerService;
    private UserDao userDao;
    private UserService userService;


    @PostMapping("/user-registration")
    public ResponseEntity<TSException> userRegister(@Valid @RequestBody UserResources userResources){
        TSException tsException = new TSException();

        Optional<UserDetails> exsistingUser= Optional.ofNullable(userDao.findByUsername(userResources.getUserName()));
//        Optional<UserDetails> exsistingUser= Optional.ofNullable(userDao.findbyNic(userResources.getNic()));
//        if (exsistingUser.isPresent()){
//            ;
//       }

        UserResources saveUser = userService.registerUser(userResources);
        return ResponseEntity.ok(tsException);
    }
}
