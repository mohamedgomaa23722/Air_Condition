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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequance")
    @SequenceGenerator(name = "product_sequance", sequenceName = "product_sequance")
    private Integer id;

    private int version;

    private String serialNr;

    private String title;

    private String description;

    private String brand;

    private BigDecimal price;

    private String pto;

    private String productionDate;
}
