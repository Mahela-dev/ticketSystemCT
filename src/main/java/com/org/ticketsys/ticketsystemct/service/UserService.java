package com.org.ticketsys.ticketsystemct.service;
import com.org.ticketsys.ticketsystemct.resources.UserResources;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserResources registerUser(UserResources userResources);
}