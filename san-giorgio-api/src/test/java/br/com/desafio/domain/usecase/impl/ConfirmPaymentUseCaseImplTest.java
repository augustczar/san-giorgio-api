package br.com.desafio.domain.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.dto.PaymentDTO;
import br.com.desafio.repository.ChargeRepository;
import br.com.desafio.repository.SellerRepository;
import br.com.desafio.service.SqsService;

@ExtendWith(MockitoExtension.class)
class ConfirmPaymentUseCaseImplTest {

    @Mock
    private SellerRepository sellerRepository;

    @Mock
    private ChargeRepository chargeRepository;

    @Mock
    private SqsService sqsService;

    @InjectMocks
    private ConfirmPaymentUseCaseImpl confirmPaymentUseCase;

    @Test
    void shouldThrowExceptionWhenSellerNotFound() {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setSellerCode("123456");

        when(sellerRepository.existsBySellerCode(anyString())).thenReturn(false);

        assertThrows(RuntimeException.class, () -> confirmPaymentUseCase.confirm(paymentDTO));
    }

}

