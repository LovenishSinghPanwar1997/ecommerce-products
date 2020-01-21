package com.team2.products.repository;

import com.team2.products.entity.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends MongoRepository<SubCategory,String> {

    SubCategory findBySubCategoryName(String subCategoryName);
    SubCategory findBySubCategoryId(String subCategoryId);

}
