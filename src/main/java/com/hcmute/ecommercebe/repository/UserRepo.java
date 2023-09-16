package com.hcmute.ecommercebe.repository;

import com.hcmute.ecommercebe.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.username=:username")
    User getUserByUsername(@Param("username") String username);
}
