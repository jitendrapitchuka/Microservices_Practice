package com.jitendra.redis.controller;

import com.jitendra.redis.entity.Product;
import com.jitendra.redis.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class productController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){

        Product product1=productService.saveProduct(product);
        return ResponseEntity.ok().body(product1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getByProductId(@PathVariable String id){

        Optional<Product> product1=productService.getProductById(id);
        return ResponseEntity.ok().body(product1);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }
}
