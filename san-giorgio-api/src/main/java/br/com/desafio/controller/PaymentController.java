package br.com.desafio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.domain.usecase.ConfirmPaymentUseCase;
import br.com.desafio.dto.PaymentDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final ConfirmPaymentUseCase confirmPaymentUseCase;

    @PutMapping
    public ResponseEntity<PaymentDTO> setPayment(@RequestBody PaymentDTO request) {
        PaymentDTO response = confirmPaymentUseCase.confirm(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}