package br.com.desafio.domain.usecase.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.desafio.domain.model.Charge;
import br.com.desafio.domain.usecase.ConfirmPaymentUseCase;
import br.com.desafio.dto.PaymentDTO;
import br.com.desafio.dto.PaymentItemDTO;
import br.com.desafio.repository.ChargeRepository;
import br.com.desafio.repository.SellerRepository;
import br.com.desafio.service.SqsService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConfirmPaymentUseCaseImpl implements ConfirmPaymentUseCase {

    private final SellerRepository sellerRepository;
    private final ChargeRepository chargeRepository;
    private final SqsService sqsService;

    @Override
    public PaymentDTO confirm(PaymentDTO paymentDTO) {
        // Verificar se o vendedor existe pelo sellerCode
        if (!sellerRepository.existsBySellerCode(paymentDTO.getSellerCode())) {
            throw new RuntimeException("Seller not found");
        }

        // Iterar pelos itens de pagamento
        for (PaymentItemDTO item : paymentDTO.getPaymentItems()) {
            // Verificar se a cobrança existe pelo chargeCode
            if (!chargeRepository.existsByChargeCode(item.getChargeCode())) {
                throw new RuntimeException("Charge code not found");
            }

            Charge charge = chargeRepository.findByChargeCode(item.getChargeCode())
                    .orElseThrow(() -> new RuntimeException("Charge not found"));

            BigDecimal valorOriginal = charge.getAmount();

            // Lógica para verificar status do pagamento
            if (item.getAmountPaid().compareTo(valorOriginal) < 0) {
                item.setPaymentStatus("partial");
                sqsService.sendToQueue(paymentDTO, "partial");
            } else if (item.getAmountPaid().compareTo(valorOriginal) == 0) {
                item.setPaymentStatus("total");
                sqsService.sendToQueue(paymentDTO, "total");
            } else {
                item.setPaymentStatus("excess");
                sqsService.sendToQueue(paymentDTO, "excess");
            }
        }

        return paymentDTO;
    }
}

