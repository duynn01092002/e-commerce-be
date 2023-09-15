package com.hcmute.ecommercebe.repository;

import com.hcmute.ecommercebe.domain.entity.ProductSpec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpecRepo extends JpaRepository<ProductSpec, String> {
}
