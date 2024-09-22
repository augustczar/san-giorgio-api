package br.com.desafio.domain.usecase;

import br.com.desafio.dto.PaymentDTO;

public interface ConfirmPaymentUseCase {

	PaymentDTO confirm(PaymentDTO paymentDTO);
}
