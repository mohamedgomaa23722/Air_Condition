package com.mg.aircondition.model;

import com.mg.aircondition.dto.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String givenName;

    private String familyName;

    private String birthDate;

    private String phoneNr;
    Set<Address> addresses = new HashSet<>(0);
}