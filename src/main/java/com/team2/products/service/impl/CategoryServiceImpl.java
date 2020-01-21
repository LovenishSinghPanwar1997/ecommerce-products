package com.team2.products.service.impl;

import com.team2.products.base.BaseResponse;
import com.team2.products.dto.CategoryDTO;
import com.team2.products.entity.Category;
import com.team2.products.repository.CategoryRepository;
import com.team2.products.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category getCategoryByCategoryId(String categoryId) {
        return categoryRepository.findByCategoryId(categoryId);
    }

    @Override
    public BaseResponse<CategoryDTO> getCategoryByName(String name) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if(null != categoryRepository.findByCategoryName(name)) {
            BeanUtils.copyProperties(categoryRepository.findByCategoryName(name), categoryDTO);
            return new BaseResponse<>(categoryDTO);
        }
        return new BaseResponse<>("");
    }

    @Override
    public BaseResponse<List<CategoryDTO>> getAllCategory() {
       return new BaseResponse<>(categoryRepository.findAll().stream().map(this::getCategoryDTOBuild).collect(Collectors.toList()));
    }

    private CategoryDTO getCategoryDTOBuild(Category category) {
        return CategoryDTO.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .image(category.getImage())
                .build();
    }

    @Override
    public BaseResponse<Category> saveCategory(Category category) {
        UUID uuid = UUID.randomUUID();
        category.setCategoryId(uuid.toString());
        return new BaseResponse<>(categoryRepository.save(category));
    }
}
