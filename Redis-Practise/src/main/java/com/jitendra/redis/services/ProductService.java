package com.jitendra.redis.services;

import com.jitendra.redis.entity.Product;
import com.jitendra.redis.repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    private Logger logger= LoggerFactory.getLogger(ProductService.class);
    public Product saveProduct(Product product){
        logger.info("product saving");
        Product pro=new Product();
        pro.setName(product.getName());
        pro.setPrice(product.getPrice());
        Product product1= productRepo.save(pro);
        logger.info(product1.toString());
        return product1;
    }

    @Cacheable(value = "GetProduct",key = "#id")
    public Optional<Product> getProductById(String id)
    {

        try{
            Thread.sleep(10000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        Optional<Product> product=productRepo.findById(id);
        if(product.isEmpty())
        {
            throw new RuntimeException("Product not found");
        }
        return product;
    }

        public List<Product> getAllProducts(){
            List<Product>products=new ArrayList<>();
            productRepo.findAll().forEach(product -> products.add(product));
            return products;
        }
}
