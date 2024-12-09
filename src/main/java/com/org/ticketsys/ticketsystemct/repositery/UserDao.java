package com.org.ticketsys.ticketsystemct.repositery;


import com.org.ticketsys.ticketsystemct.domian.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends JpaRepository<UserDetails, Integer> {
    public UserDetails findByUsername(String username);
    public UserDetails findbyNic(String nic);
}
