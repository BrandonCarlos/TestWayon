package com.wayoncompany.wayon.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wayoncompany.wayon.application.dto.TransferRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        webEnvironment =
                SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class TransferIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldScheduleTransfer() {

        TransferRequest request =
                new TransferRequest();

        request.setSourceAccount(
                "1234567890");

        request.setDestinationAccount(
                "0987654321");

        request.setAmount(
                BigDecimal.valueOf(1000));

        request.setTransferDate(
                LocalDate.now().plusDays(45));

        var response =
                restTemplate.postForEntity(
                        "http://localhost:" +
                                port +
                                "/api/transfers",
                        request,
                        String.class
                );

        assertEquals(
                200,
                response.getStatusCodeValue()
        );
    }
}
