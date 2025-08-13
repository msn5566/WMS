package com.wms.controller;

// Required imports (see instructions)
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wms.dto.InventoryDto;
import com.wms.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class InventoryControllerTest {

    private MockMvc mockMvc;
    @Mock
    private InventoryService inventoryService;
    @InjectMocks
    private InventoryController inventoryController;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
        mockMvc = MockMvcBuilders.standaloneSetup(inventoryController).build();
    }

    @Test
    void shouldAddInventory_whenValidRequest() throws Exception {
        InventoryDto inventoryDto = createSampleInventoryDto();
        doNothing().when(inventoryService).addInventory(any(InventoryDto.class));

        mockMvc.perform(post("/api/inventory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inventoryDto)))
                .andExpect(status().isCreated())
                .andExpect(content().string("Inventory added successfully"));

        verify(inventoryService, times(1)).addInventory(any(InventoryDto.class));
    }



    @Test
    void shouldUpdateInventory_whenValidRequest() throws Exception {
        InventoryDto inventoryDto = createSampleInventoryDto();
        doNothing().when(inventoryService).updateInventory(any(InventoryDto.class));

        mockMvc.perform(put("/api/inventory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inventoryDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Inventory updated successfully"));

        verify(inventoryService, times(1)).updateInventory(any(InventoryDto.class));
    }


    @Test
    void shouldDeleteInventory_whenValidRequest() throws Exception {
        String skuId = "sku123";
        String locationId = "loc456";
        doNothing().when(inventoryService).deleteInventory(skuId, locationId);

        mockMvc.perform(delete("/api/inventory")
                        .param("skuId", skuId)
                        .param("locationId", locationId))
                .andExpect(status().isOk())
                .andExpect(content().string("Inventory deleted successfully"));

        verify(inventoryService, times(1)).deleteInventory(skuId, locationId);
    }

    @Test
    void shouldGetInventory_whenValidRequest() throws Exception {
        String skuId = "sku123";
        String locationId = "loc456";
        InventoryDto inventoryDto = createSampleInventoryDto();
        when(inventoryService.getInventory(skuId, locationId)).thenReturn(inventoryDto);

        mockMvc.perform(get("/api/inventory")
                        .param("skuId", skuId)
                        .param("locationId", locationId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(inventoryDto)));

        verify(inventoryService, times(1)).getInventory(skuId, locationId);
    }



    private InventoryDto createSampleInventoryDto() {
        return InventoryDto.builder()
                .inventoryId("inv789")
                .skuId("sku123")
                .locationId("loc456")
                .quantity(100)
                .lastUpdated(LocalDateTime.now())
                .build();
    }

}