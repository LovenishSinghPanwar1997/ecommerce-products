package com.team2.products.controller;

import com.team2.products.base.BaseResponse;
import com.team2.products.dto.SubCategoryDTO;
import com.team2.products.entity.SubCategory;
import com.team2.products.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subCategory")
@CrossOrigin(origins = {"*"})
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping("/save")
    public BaseResponse<SubCategory> stave(@RequestBody SubCategoryDTO subCategoryDTO){
        return subCategoryService.saveSubcategory(subCategoryDTO);
    }

}
