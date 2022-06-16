package com.example.fruitweb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code", length = 20)
    private String code;

    @OneToMany(mappedBy = "discount")
    private List<Order> orderDiscount;

}