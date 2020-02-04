package com.team2.products.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class MerchantProductDTO {

    private String productId;
    private String productName;
    private Double productPrice;
    private String productDescription;
    private String usp;
    private Integer stock;
    private Integer productSold;

}
