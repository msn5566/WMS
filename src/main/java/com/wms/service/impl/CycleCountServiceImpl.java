
package com.wms.service.impl;

import com.wms.dto.CycleCountDto;
import com.wms.exception.ResourceNotFoundException;
import com.wms.model.Inventory;
import com.wms.repository.InventoryRepository;
import com.wms.service.CycleCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CycleCountServiceImpl implements CycleCountService {

    private final InventoryRepository inventoryRepository;

    @Override
    public void performCycleCount(CycleCountDto cycleCountDto) {
        Inventory inventory = inventoryRepository.findBySkuAndLocationId(cycleCountDto.getSkuId(), cycleCountDto.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for SKU: " + cycleCountDto.getSkuId() + " and Location: " + cycleCountDto.getLocationId()));

        // In a real system, logic for discrepancy handling and reporting would go here.
        inventory.setQuantity(cycleCountDto.getCountedQuantity());
        inventory.setLastUpdated(LocalDateTime.now()); // Update the lastUpdated timestamp
        inventoryRepository.save(inventory);
    }
}