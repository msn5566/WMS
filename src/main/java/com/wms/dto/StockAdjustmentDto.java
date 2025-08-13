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
public class StockAdjustmentDto {
    @NotBlank
    private String skuId;

    @NotBlank
    private String locationId;

    @NotNull
    private int adjustmentQuantity;

    @NotBlank
    private String reason;

    private LocalDateTime timestamp;

}