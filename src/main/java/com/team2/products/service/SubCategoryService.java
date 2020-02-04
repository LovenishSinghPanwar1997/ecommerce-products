package com.team2.products.service;

import com.team2.products.base.BaseResponse;
import com.team2.products.dto.SubCategoryDTO;
import com.team2.products.entity.SubCategory;

public interface SubCategoryService {

    SubCategory getSubCategoryByName(String subCategoryName);
    SubCategory getSubcategoryBySybcategoryId(String subcategoryId);
    BaseResponse<SubCategory> saveSubcategory(SubCategoryDTO subCategoryDTO);

}
