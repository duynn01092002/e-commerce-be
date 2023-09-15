package com.hcmute.ecommercebe.repository;

import com.hcmute.ecommercebe.domain.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeRepo extends JpaRepository<ProductAttribute, String> {
}
