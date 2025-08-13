
package com.wms.service.impl;

import com.wms.dto.StockAdjustmentDto;
import com.wms.exception.ResourceNotFoundException;
import com.wms.model.Inventory;
import com.wms.model.InventoryAdjustment;
import com.wms.repository.InventoryAdjustmentRepository;
import com.wms.repository.InventoryRepository;
import com.wms.service.StockAdjustmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StockAdjustmentServiceImpl implements StockAdjustmentService {

    private final InventoryRepository inventoryRepository;
    private final InventoryAdjustmentRepository inventoryAdjustmentRepository;


    @Override
    @Transactional
    public void adjustStock(StockAdjustmentDto stockAdjustmentDto) {
        Inventory inventory = inventoryRepository.findBySkuAndLocationId(stockAdjustmentDto.getSkuId(), stockAdjustmentDto.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for SKU: " + stockAdjustmentDto.getSkuId() + " and Location: " + stockAdjustmentDto.getLocationId()));

        int originalQuantity = inventory.getQuantity();
        int newQuantity = originalQuantity + stockAdjustmentDto.getAdjustmentQuantity();

        inventory.setQuantity(newQuantity);
        inventory.setLastUpdated(LocalDateTime.now());
        inventoryRepository.save(inventory);

        InventoryAdjustment adjustment = InventoryAdjustment.builder()
                .sku(inventory.getSku())
                .beforeQty(originalQuantity)
                .afterQty(newQuantity)
                .reason(stockAdjustmentDto.getReason())
                .adjustedBy(stockAdjustmentDto.getReason()) // Replace with actual adjustedBy info when available
                .timestamp(LocalDateTime.now())
                .build();
        inventoryAdjustmentRepository.save(adjustment);
    }
}