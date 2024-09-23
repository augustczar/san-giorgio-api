package br.com.desafio.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.desafio.domain.usecase.ConfirmPaymentUseCase;
import br.com.desafio.dto.PaymentDTO;
import br.com.desafio.dto.PaymentItemDTO;

@WebMvcTest(PaymentController.class)
class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConfirmPaymentUseCase confirmPaymentUseCase;

    @Test
    void shouldReturnOkWhenPaymentIsValid() throws Exception {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setSellerCode("123456");

        PaymentItemDTO paymentItemDTO = new PaymentItemDTO();
        paymentItemDTO.setChargeCode("ABC123");
        paymentItemDTO.setAmountPaid(BigDecimal.valueOf(500));

        paymentDTO.setPaymentItems(List.of(paymentItemDTO));

        when(confirmPaymentUseCase.confirm(eq(paymentDTO))).thenReturn(paymentDTO);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(paymentDTO);

        mockMvc.perform(put("/api/payment")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json));

        verify(confirmPaymentUseCase, times(1)).confirm(eq(paymentDTO));
    }

}

