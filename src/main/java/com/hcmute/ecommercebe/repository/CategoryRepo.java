package com.hcmute.ecommercebe.repository;

import com.hcmute.ecommercebe.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String> {
}
