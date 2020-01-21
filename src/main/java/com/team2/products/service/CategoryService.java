package com.team2.products.service;

import com.team2.products.base.BaseResponse;
import com.team2.products.dto.CategoryDTO;
import com.team2.products.entity.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryByCategoryId(String categoryId);
    BaseResponse<CategoryDTO> getCategoryByName(String name);
    BaseResponse<List<CategoryDTO>> getAllCategory();
    BaseResponse<Category> saveCategory(Category category);

}
