package com.mg.aircondition.model;

import com.mg.aircondition.service.CompositKey;
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
    @EmbeddedId
    private CompositKey compositKey;

    private String serialNr;

    private String title;

    private String description;

    private String brand;

    private BigDecimal price;

    private String pto;

    private String productionDate;
}
