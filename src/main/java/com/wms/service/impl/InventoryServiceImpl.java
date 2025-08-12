
package com.wms.service.impl;

import com.wms.dto.InventoryDto;
import com.wms.model.Inventory;
import com.wms.repository.InventoryRepository;
import com.wms.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public void addInventory(InventoryDto inventoryDto) {
        Inventory inventory = Inventory.builder()
                .sku(inventoryDto.getSkuId())
                .locationId(inventoryDto.getLocationId())
                .quantity(inventoryDto.getQuantity())
                .lastUpdated(LocalDateTime.now())
                .build();
        inventoryRepository.save(inventory);
    }

    @Override
    public void updateInventory(InventoryDto inventoryDto) {
        Inventory inventory = inventoryRepository.findBySkuAndLocationId(inventoryDto.getSkuId(), inventoryDto.getLocationId())
                .orElseThrow(() -> new RuntimeException("Inventory not found")); // Handle appropriately
        inventory.setQuantity(inventoryDto.getQuantity());
        inventory.setLastUpdated(LocalDateTime.now());
        inventoryRepository.save(inventory);
    }

    @Override
    public void deleteInventory(String skuId, String locationId) {
        Inventory inventory = inventoryRepository.findBySkuAndLocationId(skuId, locationId)
                .orElseThrow(() -> new RuntimeException("Inventory not found")); // Handle appropriately
        inventoryRepository.delete(inventory);
    }

    @Override
    public InventoryDto getInventory(String skuId, String locationId) {
        Inventory inventory = inventoryRepository.findBySkuAndLocationId(skuId, locationId)
                .orElseThrow(() -> new RuntimeException("Inventory not found")); // Handle appropriately

        return InventoryDto.builder()
                .inventoryId(inventory.getInventoryId())
                .skuId(inventory.getSku())
                .locationId(inventory.getLocationId())
                .quantity(inventory.getQuantity())
                .lastUpdated(inventory.getLastUpdated())
                .build();
    }
}