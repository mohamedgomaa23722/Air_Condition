package com.mg.aircondition.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(com.mg.aircondition.service.IdClass.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    private int version;

    private String serialNr;

    private String title;

    private String description;

    private String brand;

    private BigDecimal price;

    private String pto;

    private String productionDate;
}
