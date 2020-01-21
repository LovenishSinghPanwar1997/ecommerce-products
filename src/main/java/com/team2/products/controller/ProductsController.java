package com.team2.products.controller;


import com.team2.products.base.BaseResponse;
import com.team2.products.client.MerchantClient;
import com.team2.products.dto.MerchantAddProdDTO;
import com.team2.products.dto.response.GetCategoriesResponse;
import com.team2.products.entity.Products;
import com.team2.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @Autowired
    MerchantClient merchantClient;

    @PostMapping("/add")
    public BaseResponse<Products> addProduct(@RequestBody MerchantAddProdDTO merchantAddProdDTO) {
         return new BaseResponse<>(productsService.addProducts(merchantAddProdDTO));
    }

    @GetMapping("/hello")
    public String getHelllo()
    {
        return merchantClient.getHello();
    }

    @GetMapping("/categories")
    public BaseResponse<GetCategoriesResponse> getCategories(){
        return new BaseResponse<>(productsService.getProductByCategories());
    }

}
