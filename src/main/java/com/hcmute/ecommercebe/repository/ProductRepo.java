package com.hcmute.ecommercebe.repository;

import com.hcmute.ecommercebe.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
}
