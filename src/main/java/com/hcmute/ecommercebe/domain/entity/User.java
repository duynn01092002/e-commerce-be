package com.hcmute.ecommercebe.domain.entity;

import com.hcmute.ecommercebe.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="tbl_user")
public class User {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "status")
    private boolean status;
}
