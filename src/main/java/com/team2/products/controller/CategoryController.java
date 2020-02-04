package com.team2.products.controller;

import com.team2.products.base.BaseResponse;
import com.team2.products.dto.CategoryDTO;
import com.team2.products.entity.Category;
import com.team2.products.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = {"*"})
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAll")
    BaseResponse<List<CategoryDTO>> getCategory() {
        return categoryService.getAllCategory();
    }

    @PostMapping("/save")
    BaseResponse<Category> saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }


}
