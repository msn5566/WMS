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
@Document("inventory")
public class Inventory {
    @Id
    private String inventoryId;

    @DBRef
    private SKU sku;

    private String locationId; // Consider referencing Location object later
    private int quantity;
    private LocalDateTime lastUpdated;
}