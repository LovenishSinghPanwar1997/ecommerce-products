package com.team2.products.service.impl;


import com.team2.products.base.BaseResponse;
import com.team2.products.dto.SubCategoryDTO;
import com.team2.products.entity.SubCategory;
import com.team2.products.repository.SubCategoryRepository;
import com.team2.products.service.CategoryService;
import com.team2.products.service.SubCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    CategoryService categoryService;

    @Override
    public SubCategory getSubCategoryByName(String subCategoryName) {
        return subCategoryRepository.findBySubCategoryName(subCategoryName);
    }

    @Override
    public SubCategory getSubcategoryBySybcategoryId(String subcategoryId) {
        return subCategoryRepository.findBySubCategoryId(subcategoryId);
    }

    @Override
    public BaseResponse<SubCategory> saveSubcategory(SubCategoryDTO subCategoryDTO) {
        UUID uuid = UUID.randomUUID();
        SubCategory subCategory = new SubCategory();
        BeanUtils.copyProperties(subCategoryDTO,subCategory);
        subCategory.setSubCategoryId(uuid.toString());
        subCategory.setCategory(categoryService.getCategoryByCategoryId(subCategoryDTO.getCategoryId()));
        return new BaseResponse<>(subCategoryRepository.save(subCategory));
    }
}
