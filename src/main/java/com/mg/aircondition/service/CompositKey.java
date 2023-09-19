package com.mg.aircondition.service;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Embeddable
public class CompositKey implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositKey that = (CompositKey) o;
        return id == that.id && version == that.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version);
    }
}
