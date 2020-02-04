package com.team2.products.service.impl;

import com.team2.products.client.MerchantClient;
import com.team2.products.dto.CategoryDTO;
import com.team2.products.dto.MerchantAddProdDTO;
import com.team2.products.dto.response.CategoryListResponse;
import com.team2.products.dto.response.GetCategoriesResponse;
import com.team2.products.dto.response.ProductListResponse;
import com.team2.products.entity.Category;
import com.team2.products.entity.Products;
import com.team2.products.repository.ProductsRepository;
import com.team2.products.service.CategoryService;
import com.team2.products.service.ProductsService;
import com.team2.products.service.SubCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements ProductsService {


    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    MerchantClient merchantClient;

    @Override
    public Products addProducts(MerchantAddProdDTO merchantAddProdDTO) {

        UUID uuid = UUID.randomUUID();
        Products products = new Products();
        BeanUtils.copyProperties(merchantAddProdDTO,products);
        if(StringUtils.isEmpty(merchantAddProdDTO.getProductId())) {
            products.setProductId(uuid.toString());
        }
        if(null!=merchantAddProdDTO.getCategories())
        {
            if(merchantAddProdDTO.getCategories().size()>0){
                products.setCategory(categoryService.getCategoryByCategoryId(merchantAddProdDTO.getCategories().get(0)));
                if(merchantAddProdDTO.getCategories().size()>1){
                    products.setSubCategory(subCategoryService.getSubcategoryBySybcategoryId(merchantAddProdDTO.getCategories().get(1)));

                }
            }
        }
        Products products1 = productsRepository.save(products);
        merchantAddProdDTO.setProductId(products1.getProductId());

        merchantClient.addProductInMerchant(merchantAddProdDTO);
        return products1;

    }

    @Override
    public GetCategoriesResponse getProductByCategories() {
        List<Products> productsList = productsRepository.findAll();
        GetCategoriesResponse getCategoriesResponse = new GetCategoriesResponse();
        List<CategoryListResponse> categoryListResponses = new ArrayList<>();
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategory().getData();
        Map<String,List<ProductListResponse>> categoryMap = new HashMap<>();
        for(CategoryDTO categoryDTO:categoryDTOS){
            categoryMap.put(categoryDTO.getCategoryId(),new ArrayList<>());
        }
        for(Products products:productsList){
            String categoryId = products.getCategory().getCategoryId();
            List<ProductListResponse> productListResponses = categoryMap.get(categoryId);
            ProductListResponse productListResponse = new ProductListResponse();
            productListResponse.setId(products.getProductId());
            productListResponse.setImage(products.getImages().get(0));
            productListResponse.setName(products.getProductName());
            productListResponse.setPrice(merchantClient.getPriceByProductId(products.getProductId()));
            productListResponses.add(productListResponse);
            categoryMap.put(categoryId,productListResponses);
        }

        for(CategoryDTO categoryDTO:categoryDTOS){
            CategoryListResponse categoryListResponse = new CategoryListResponse();
            categoryListResponse.setId(categoryDTO.getCategoryId());
            categoryListResponse.setName(categoryDTO.getCategoryName());
            categoryListResponse.setImage(categoryDTO.getImage());
            categoryListResponse.setProducts(categoryMap.get(categoryDTO.getCategoryId()));
            categoryListResponses.add(categoryListResponse);
        }

        getCategoriesResponse.setCategories(categoryListResponses);

        return getCategoriesResponse;


    }

    @Override
    public List<Products> getAllProducts() {
        List<Products> productsList = productsRepository.findAll();
        return productsList;
    }

    @Override
    public Products getProductById(String productId) {
       return productsRepository.findByProductId(productId);
    }
}
