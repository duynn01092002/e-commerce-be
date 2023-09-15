package com.hcmute.ecommercebe.repository;

import com.hcmute.ecommercebe.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, String> {
}
