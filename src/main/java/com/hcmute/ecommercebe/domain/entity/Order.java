package com.hcmute.ecommercebe.domain.entity;

import com.hcmute.ecommercebe.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="tbl_order")
public class Order {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "createdAt")
    private Date createdAt = new Date();

    @Column(name = "lastUpdatedAt")
    private Date lastUpdatedAt = new Date();

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name="total")
    private Double total;

    @ManyToOne
    @JoinColumn(name="user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
