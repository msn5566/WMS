package com.wms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("purchase_orders")
public class PurchaseOrder {
    @Id
    private String purchaseOrderId;
    private String supplier; // You'll likely want a Supplier entity and @DBRef in a real application
    private LocalDateTime orderDate;
    private List<PurchaseOrderItem> items;
}