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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serialNr;

    private String title;

    private String description;

    private String brand;

    private BigDecimal price;

    private String pto;

    private String productionDate;
}
