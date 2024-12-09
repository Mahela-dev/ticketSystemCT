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
    public ResponseEntity<String> userRegister(@Valid @RequestBody UserResources userResources) {
        try {
            // Validate username
            Optional<UserDetails> existingUser = Optional.ofNullable(userDao.findByUsername(userResources.getUsername()));
            if (existingUser.isPresent()) {
                throw new TSException("USER_EXISTS", "Username already exists", "The username provided is already in use.");
            }

            // Validate fields
            if (userResources.getUsername() == null || userResources.getUsername().isEmpty()) {
                throw new TSException("INVALID_FIELD", "Username is required", "The username field cannot be null or empty.");
            }try {
                // Validate username
                Optional<UserDetails> existingUserNid = Optional.ofNullable(userDao.findbyNic(userResources.getNic()));
                if (existingUserNid.isPresent()) {
                    throw new TSException("USER_EXISTS", "User NID already exists", "The user NID provided is already in use.");
                }

                // Validate fields
                if (userResources.getNic() == null || userResources.getNic().isEmpty()) {
                    throw new TSException("INVALID_FIELD", "User NID is required", "The user NID field cannot be null or empty.");
                }

            } catch (TSException e) {
                // Handle the exception and return a meaningful response
                return ResponseEntity.badRequest().body("Error: " + e.getErrorMessage() + " - " + e.getErrorDetail());
            }

            // If no errors, proceed with registration
            userService.registerUser(userResources);

            // Send a successful response
            return ResponseEntity.ok("User registered successfully!");
        } catch (TSException e) {
            // Handle the exception and return a meaningful response
            return ResponseEntity.badRequest().body("Error: " + e.getErrorMessage() + " - " + e.getErrorDetail());
        }
    }

}
