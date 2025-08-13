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

    private String sku; // Updated field type

    private String locationId; // Consider referencing Location object later
    private int quantity;
    private LocalDateTime lastUpdated;
}