package com.hcmute.ecommercebe.repository;

import com.hcmute.ecommercebe.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
