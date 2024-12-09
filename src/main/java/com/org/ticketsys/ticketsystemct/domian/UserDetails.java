package com.org.ticketsys.ticketsystemct.domian;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "USER_DETAILS", uniqueConstraints = @UniqueConstraint(columnNames = {"NIC","USER_NAME"}))
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // for auto genarated table column id
    private int id;
    private String nic;
    private String userName;
    private String fullName;
    private String password;
    private String email;
    private int mobileNumber;
    private int userType;                       // for identify cudtomer or vendor
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String createdBy;
    private String modifiedBy;


    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();  // Set createdDate to the current timestamp
        this.createdBy = userName;
        this.modifiedDate = null;
        this.modifiedBy = null;
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifiedDate = LocalDateTime.now();  // Set updatedDate to the current timestamp
        this.modifiedBy = userName;
    }


}
