package com.wms.service.impl;

import com.wms.dto.StockAdjustmentDto;
import com.wms.exception.ResourceNotFoundException;
import com.wms.model.Inventory;
import com.wms.model.InventoryAdjustment;
import com.wms.repository.InventoryAdjustmentRepository;
import com.wms.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class StockAdjustmentServiceImplTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @Mock
    private InventoryAdjustmentRepository inventoryAdjustmentRepository;

    @InjectMocks
    private StockAdjustmentServiceImpl stockAdjustmentService;

    private StockAdjustmentDto stockAdjustmentDto;
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        stockAdjustmentDto = StockAdjustmentDto.builder()
                .skuId("SKU-001")
                .locationId("LOC-001")
                .adjustmentQuantity(10)
                .reason("Damaged goods")
                .timestamp(LocalDateTime.now())
                .build();

        inventory = Inventory.builder()
                .sku("SKU-001")
                .locationId("LOC-001")
                .quantity(100)
                .lastUpdated(LocalDateTime.now().minusDays(1))
                .build();
    }

    @Test
    void shouldAdjustStock_whenInventoryExists() {
        when(inventoryRepository.findBySkuAndLocationId(stockAdjustmentDto.getSkuId(), stockAdjustmentDto.getLocationId()))
                .thenReturn(Optional.of(inventory));

        stockAdjustmentService.adjustStock(stockAdjustmentDto);

        ArgumentCaptor<Inventory> inventoryCaptor = ArgumentCaptor.forClass(Inventory.class);
        verify(inventoryRepository).save(inventoryCaptor.capture());
        Inventory updatedInventory = inventoryCaptor.getValue();
        assertEquals(110, updatedInventory.getQuantity()); // 100 + 10
        assertNotNull(updatedInventory.getLastUpdated());


        ArgumentCaptor<InventoryAdjustment> adjustmentCaptor = ArgumentCaptor.forClass(InventoryAdjustment.class);
        verify(inventoryAdjustmentRepository).save(adjustmentCaptor.capture());
        InventoryAdjustment adjustment = adjustmentCaptor.getValue();

        assertEquals("SKU-001", adjustment.getSku());
        assertEquals(100, adjustment.getBeforeQty());
        assertEquals(110, adjustment.getAfterQty());
        assertEquals("Damaged goods", adjustment.getReason());
        assertNotNull(adjustment.getTimestamp());
    }


    @Test
    void shouldThrowException_whenInventoryDoesNotExist() {
        when(inventoryRepository.findBySkuAndLocationId(anyString(), anyString()))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> stockAdjustmentService.adjustStock(stockAdjustmentDto));

        verify(inventoryRepository, never()).save(any());
        verify(inventoryAdjustmentRepository, never()).save(any());
    }

}