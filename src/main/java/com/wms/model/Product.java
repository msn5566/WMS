package com.wms.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
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