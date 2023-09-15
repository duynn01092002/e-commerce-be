package com.hcmute.ecommercebe.repository;

import com.hcmute.ecommercebe.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, String> {
}
