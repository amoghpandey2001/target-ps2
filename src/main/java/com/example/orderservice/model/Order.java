package com.example.orderservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "orderId")
    private String orderId;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "transactionId")
    private String transactionId;
    @Column(name = "status")
    private boolean status;
    @Column(name = "bank")
    private String bank;
}

