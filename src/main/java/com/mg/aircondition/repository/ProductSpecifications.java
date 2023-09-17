package com.mg.aircondition.repository;

import com.mg.aircondition.dto.ProductFilter;
import com.mg.aircondition.model.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpecifications {

    public static Specification<Product> hasTitle(String title) {
        return ((root, query, criteriaBuilder) -> (title == null) ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("title"), title));
    }

    public static Specification<Product> hasPrice(BigDecimal price) {
        return ((root, query, criteriaBuilder) -> (price == null) ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("price"), price));
    }


    public static Specification<Product> hasBrand(String brand) {
        return ((root, query, criteriaBuilder) -> (brand == null) ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("brand"), brand));
    }

    public static Specification<Product> fullFilter(ProductFilter productFilter) {
        return Specification
                .where(hasPrice(productFilter.getPrice()))
                .and(hasTitle(productFilter.getTitle()))
                .and(hasBrand(productFilter.getBrand()));
    }
}
