package com.wms.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Document("purchase_orders")
public class PurchaseOrder {
    @Id
    private String purchaseOrderId;
    private String supplier;
    private LocalDateTime orderDate;
    private List<PurchaseOrderItem> items;
}