package com.team2.products.service;


import com.team2.products.dto.MerchantAddProdDTO;
import com.team2.products.dto.response.GetCategoriesResponse;
import com.team2.products.entity.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {

Products addProducts(MerchantAddProdDTO merchantAddProdDTO);

GetCategoriesResponse getProductByCategories();

}
