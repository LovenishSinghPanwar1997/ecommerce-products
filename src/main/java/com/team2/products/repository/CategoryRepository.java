package com.team2.products.repository;

import com.team2.products.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {


    Category findByCategoryName(String categoryName);
    Category findByCategoryId(String categoryId);
}
