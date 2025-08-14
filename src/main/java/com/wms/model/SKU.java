package com.wms.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("skus")
public class SKU {
    @Id
    private String skuId;
    @DBRef
    private Product product;
    private String barcode;
    private double price;
    private double weight;
    private String status;
}