package com.team2.products.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "category")
public class Category extends BaseEntity{

    @Id
    private String categoryId;
    private String categoryName;
    private String image;


}
