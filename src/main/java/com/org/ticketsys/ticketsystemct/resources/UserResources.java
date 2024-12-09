package com.org.ticketsys.ticketsystemct.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResources {
    private int id;
    private String nic;
    private String userName;
    private String fullName;
    private String password;
    private String email;
    private int mobileNumber;
    private int userType;
}
