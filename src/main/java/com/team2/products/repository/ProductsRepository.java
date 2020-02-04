package com.team2.products.repository;

import com.team2.products.entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<Products,String> {

        Products findByProductId(String productId);

}
