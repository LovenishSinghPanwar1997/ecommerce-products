package com.team2.products.client;

import com.team2.products.base.BaseResponse;
import com.team2.products.dto.MerchantAddProdDTO;
import com.team2.products.dto.MerchantProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value="merchantClient",url="http://localhost:8081")
public interface MerchantClient {

    @RequestMapping(method = RequestMethod.GET,value = "/merchant/hello")
    String getHello();

    @RequestMapping(method = RequestMethod.POST,value = "/merchant-product/add")
    BaseResponse<MerchantProductDTO> addProductInMerchant(@RequestBody MerchantAddProdDTO merchantAddProdDTO);

    @GetMapping("/merchant-product/getProductPrice/{productId}")
    Double getPriceByProductId(@PathVariable("productId") String productId);

}
