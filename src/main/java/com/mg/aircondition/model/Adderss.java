package com.mg.aircondition.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Adderss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String streetNr;

    private String streetName;

    private String houseNr;

    private String city;

    private String country;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
