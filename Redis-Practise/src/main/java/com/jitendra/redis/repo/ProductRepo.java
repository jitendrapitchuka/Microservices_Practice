package com.jitendra.redis.repo;

import com.jitendra.redis.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product,String> {
}
