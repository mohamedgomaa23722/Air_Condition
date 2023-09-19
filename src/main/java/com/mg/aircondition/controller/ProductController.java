package com.mg.aircondition.controller;

import com.mg.aircondition.api.ProductsApi;
import com.mg.aircondition.dto.Product;
import com.mg.aircondition.dto.ProductFilter;
import com.mg.aircondition.dto.StatusResponse;
import com.mg.aircondition.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController implements ProductsApi {
    private final ProductService productService;

    @Override
    public ResponseEntity<StatusResponse> createProduct(String xToken, Product product) {
        return null;
    }

    @Override
    public ResponseEntity<List<Product>> getProducts(Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseEntity<List<Product>> productFilter(Integer page, Integer size, ProductFilter productFilter) {
        return ResponseEntity.ok().body(productService.filter(productFilter));
    }


    @PostMapping("/uploadmultiProd")
    public BatchUploadResponse createProducts(@RequestBody BatchUpload batchUpload, @RequestParam(name = "name", required = false) String name){
        BatchUploadResponse batchUploadResponse = new BatchUploadResponse();

        long startTime = System.currentTimeMillis();
        batchUploadResponse.isUploaded = productService.batchInsert(batchUpload.products, name);
        batchUploadResponse.timeInSeconds = (float) (System.currentTimeMillis() - startTime) / 1000;

        return batchUploadResponse;
    }
}
class BatchUpload{
    public List<Product> products;
}

class BatchUploadResponse{
    public boolean isUploaded;
    public float timeInSeconds;
}
//13.300004