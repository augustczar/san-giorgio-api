package br.com.desafio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.desafio.service.MockSqsService;
import br.com.desafio.service.SqsService;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class SqsServiceConfig {

    @Bean
    @Profile("mock-sqs")
    SqsService mockSqsService(SqsClient sqsClient) {
        return new MockSqsService(sqsClient);
    }

    @Bean
    @Profile("!mock-sqs")
    SqsService realSqsService(SqsClient sqsClient) {
        return new SqsService(sqsClient);
    }
}
