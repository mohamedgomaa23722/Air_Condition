package com.mg.aircondition.service;

import com.mg.aircondition.dto.Product;
import com.mg.aircondition.dto.ProductFilter;
import com.mg.aircondition.mapper.ProductMapper;
import com.mg.aircondition.repository.ProductRepository;
import com.mg.aircondition.repository.ProductSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public boolean batchInsert(List<Product> products, String name) {
//        products.stream()
//                .parallel()
//                .forEach(product -> {
//                        productRepository.save(productMapper.toEntity(product));
//                });

       productRepository.saveAll(productMapper.toEntityList(products));
        return true;
    }

    public List<Product> filter(ProductFilter productFilter) {
        List<com.mg.aircondition.model.Product> all = productRepository.findAll(ProductSpecifications.fullFilter(productFilter));
        return productMapper.toDtoList(all);
    }
}

// when insert 10000 product
//49.021000  product by product
//7.349000 in parallel

// when insert 50000 product
//592.086060 product by product
//75.353996 in parallel