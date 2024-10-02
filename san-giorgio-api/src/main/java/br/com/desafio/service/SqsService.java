package br.com.desafio.service;

import br.com.desafio.dto.PaymentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@RequiredArgsConstructor
@Service
public class SqsService {

    private final SqsClient sqsClient;

    @Value("${aws.sqs.queue-urls.partial}")
    private String partialQueueUrl;

    @Value("${aws.sqs.queue-urls.total}")
    private String totalQueueUrl;

    @Value("${aws.sqs.queue-urls.excess}")
    private String excessQueueUrl;

    public void sendToQueue(PaymentDTO paymentDTO, String type) {
        String queueUrl = getQueueUrl(type);
        SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(paymentDTO.toString())
                .build();
        sqsClient.sendMessage(sendMsgRequest);
    }

    private String getQueueUrl(String type) {
        switch (type) {
            case "partial":
                return partialQueueUrl;
            case "total":
                return totalQueueUrl;
            case "excess":
                return excessQueueUrl;
            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }
}
