package com.example.fruitweb.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "creator")
    private Integer creator;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "status")
    private Integer status;

    @Column(name = "total", precision = 10)
    private BigDecimal total;

    @Column(name = "discount_id")
    private Integer discountId;


}