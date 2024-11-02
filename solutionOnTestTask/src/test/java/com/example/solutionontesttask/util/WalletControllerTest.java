package com.example.solutionontesttask.util;

import com.example.solutionontesttask.controller.WalletController;
import com.example.solutionontesttask.dto.UpdateWalletDto;
import com.example.solutionontesttask.model.OperationType;
import com.example.solutionontesttask.service.WalletService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WalletControllerTest {
    @Mock
    private WalletService walletService;

    @InjectMocks
    private WalletController walletController;
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;
    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(walletController).build();
        objectMapper =new ObjectMapper();
    }

    @Test
    void updateWallet() throws Exception{
        UpdateWalletDto walletDto = new UpdateWalletDto();
        walletDto.setOperationType(OperationType.DEPOSIT);
        walletDto.setWalletId(UUID.fromString("a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11"));
        walletDto.setAmount(1000.02);
        String workerJson = objectMapper.writeValueAsString(walletDto);
        mockMvc.perform(post("/api/v1/wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(workerJson))
                .andExpect(status().isOk()) ;

    }

    @Test
    void findBalanceById_EverythingIsFine() throws Exception{
        Long balance = 328946750L;
        when(walletService.findBalanceById(UUID.fromString("a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11")))
                .thenReturn( balance);
        mockMvc.perform(get("/api/v1/wallet/{id}", UUID.fromString("a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(3289467.50));
    }


}
