package com.org.ticketsys.ticketsystemct.service.impl;
import com.org.ticketsys.ticketsystemct.domian.UserDetails;
import com.org.ticketsys.ticketsystemct.repositery.UserDao;
import com.org.ticketsys.ticketsystemct.resources.UserResources;
import com.org.ticketsys.ticketsystemct.service.UserService;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Data
@Transactional
@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper,UserDao userDao) {
        this.modelMapper = modelMapper;
        this.userDao = userDao;
    }
    @Override
    public UserResources registerUser(UserResources userResources) {
        UserDetails userDetails = modelMapper.map(userResources, UserDetails.class);

        userDetails.setCreatedBy("SYSTEM");
        userDetails.setCreatedDate(LocalDateTime.now());

        UserDetails savedUser = userDao.save(userDetails);

        return modelMapper.map(savedUser, UserResources.class);
    }


}
