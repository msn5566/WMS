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
    private String supplier; // Could be a reference to Supplier object later
    private LocalDateTime orderDate;
    private String status;
    private List<PurchaseOrderItem> items;
}