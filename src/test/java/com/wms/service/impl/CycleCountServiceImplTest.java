package com.wms.service.impl;

import com.wms.dto.CycleCountDto;
import com.wms.exception.ResourceNotFoundException;
import com.wms.model.Inventory;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

class CycleCountServiceImplTest {
    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private CycleCountServiceImpl cycleCountService;

    private CycleCountDto cycleCountDto;
    private Inventory existingInventory;

    @BeforeEach
    void setup() {
        cycleCountDto = CycleCountDto.builder()
                .skuId("SKU-001")
                .locationId("LOC-001")
                .countedQuantity(50)
                .build();


        existingInventory = Inventory.builder()
                .id("inventoryId")
                .sku(cycleCountDto.getSkuId())
                .locationId(cycleCountDto.getLocationId())
                .quantity(100)
                .lastUpdated(LocalDateTime.now())
                .build();

    }


    @Test
    void shouldUpdateInventoryQuantity_whenInventoryExists() {
        when(inventoryRepository.findBySkuAndLocationId(anyString(), anyString())).thenReturn(Optional.of(existingInventory));

        cycleCountService.performCycleCount(cycleCountDto);

        ArgumentCaptor<Inventory> inventoryCaptor = ArgumentCaptor.forClass(Inventory.class);
        verify(inventoryRepository).save(inventoryCaptor.capture());
        Inventory updatedInventory = inventoryCaptor.getValue();

        assertEquals(cycleCountDto.getCountedQuantity(), updatedInventory.getQuantity());
        assertNotNull(updatedInventory.getLastUpdated());

    }


    @Test
    void shouldThrowException_whenInventoryDoesNotExist() {

        when(inventoryRepository.findBySkuAndLocationId(anyString(), anyString())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> cycleCountService.performCycleCount(cycleCountDto));

        verify(inventoryRepository, never()).save(any(Inventory.class));
    }

}