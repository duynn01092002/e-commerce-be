package com.hcmute.ecommercebe.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity
@Data
@Table(name="tbl_order_item")
public class OrderItem {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private String productPrice;

    @Column(name = "quantity")
    private Double quantity;

    @ManyToOne
    @JoinColumn(name="order_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;
}
