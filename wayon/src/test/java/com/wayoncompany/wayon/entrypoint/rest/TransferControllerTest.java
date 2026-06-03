package com.wayoncompany.wayon.entrypoint.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wayoncompany.wayon.application.dto.TransferRequest;
import com.wayoncompany.wayon.domain.ports.in.GetTransfersUseCase;
import com.wayoncompany.wayon.domain.ports.in.ScheduleTransferUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransferController.class)
public class TransferControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private ScheduleTransferUseCase scheduleTransferUseCase;

    @MockBean
    private GetTransfersUseCase getTransfersUseCase;

    @Test
    void shouldValidateRequest() throws Exception {

        TransferRequest request =
                new TransferRequest();

        request.setSourceAccount("123");

        request.setDestinationAccount("456");

        request.setAmount(
                BigDecimal.valueOf(1000));

        request.setTransferDate(
                LocalDate.now().plusDays(5));

        mockMvc.perform(
                        post("/api/transfers")
                                .contentType("application/json")
                                .content(
                                        mapper.writeValueAsString(
                                                request))
                )
                .andExpect(status().isBadRequest());
    }
}
