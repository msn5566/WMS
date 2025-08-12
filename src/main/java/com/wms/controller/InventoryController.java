
package com.wms.controller;

import com.wms.dto.InventoryDto;
import com.wms.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<String> addInventory(@Valid @RequestBody InventoryDto inventoryDto) {
        inventoryService.addInventory(inventoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Inventory added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateInventory(@Valid @RequestBody InventoryDto inventoryDto) {
        inventoryService.updateInventory(inventoryDto);
        return ResponseEntity.ok("Inventory updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteInventory(@RequestParam String skuId, @RequestParam String locationId) {
        inventoryService.deleteInventory(skuId, locationId);
        return ResponseEntity.ok("Inventory deleted successfully");
    }

    @GetMapping
    public ResponseEntity<InventoryDto> getInventory(@RequestParam String skuId, @RequestParam String locationId) {
        InventoryDto inventoryDto = inventoryService.getInventory(skuId, locationId);
        return ResponseEntity.ok(inventoryDto);
    }
}