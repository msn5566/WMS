
package com.wms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {
    private String inventoryId;

    @NotBlank(message = "SKU ID is required")
    private String skuId;

    @NotBlank(message = "Location ID is required")
    private String locationId;

    @NotNull(message = "Quantity is required")
    private int quantity;

    private LocalDateTime lastUpdated;
}