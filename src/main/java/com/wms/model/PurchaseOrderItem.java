package com.wms.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Builder
public class PurchaseOrderItem {
    @DBRef
    private SKU sku;
    private int quantity;
    private double price;
}