package com.team2.products.client;

import com.team2.products.base.BaseResponse;
import com.team2.products.dto.MerchantAddProdDTO;
import com.team2.products.dto.MerchantProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="merchantClient",url="http://localhost:8081")
public interface MerchantClient {

    @RequestMapping(method = RequestMethod.GET,value = "/merchant/hello")
    String getHello();

    @RequestMapping(method = RequestMethod.POST,value = "/merchant-product/add")
    BaseResponse<MerchantProductDTO> addProductInMerchant(@RequestBody MerchantAddProdDTO merchantAddProdDTO);

}
