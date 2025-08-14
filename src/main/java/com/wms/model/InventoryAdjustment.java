package com.wms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("inventory_adjustments")
public class InventoryAdjustment {

    @Id
    private String adjustmentId;
    @DBRef
    private SKU sku;

    private int beforeQty;
    private int afterQty;
    private String reason;
    private String adjustedBy; // Probably a userId
    private LocalDateTime timestamp;
}