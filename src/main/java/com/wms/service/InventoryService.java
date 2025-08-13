
package com.wms.service;

import com.wms.dto.InventoryDto;

public interface InventoryService {
    void addInventory(InventoryDto inventoryDto);
    void updateInventory(InventoryDto inventoryDto);
    void deleteInventory(String skuId, String locationId);
    InventoryDto getInventory(String skuId, String locationId);
}