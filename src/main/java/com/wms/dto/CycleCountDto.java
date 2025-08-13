package com.wms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CycleCountDto {
    @NotBlank
    private String skuId;
    @NotBlank
    private String locationId;
    @NotNull
    private int countedQuantity;

}