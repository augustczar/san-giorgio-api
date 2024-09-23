package br.com.desafio.service;

import br.com.desafio.dto.PaymentDTO;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.sqs.SqsClient;

@Slf4j
public class MockSqsService extends SqsService {

    public MockSqsService(SqsClient sqsClient) {
        super(sqsClient);
    }

    @Override
    public void sendToQueue(PaymentDTO paymentDTO, String type) {
        log.info("Simulando envio para fila SQS. Tipo de pagamento: {} - Detalhes: {}", type, paymentDTO);
        
        switch (type) {
            case "partial":
                log.info("Simulando envio para fila de pagamentos parciais.");
                break;
            case "total":
                log.info("Simulando envio para fila de pagamentos totais.");
                break;
            case "excess":
                log.info("Simulando envio para fila de pagamentos excedentes.");
                break;
            default:
                throw new IllegalArgumentException("Tipo de pagamento inválido: " + type);
        }
    }
}
