package com.wms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("products")
public class Product {
    @Id
    private String productId;
    private String name;
    private String description;
    private String category;
    private String unitOfMeasure;
    private boolean active;
}