package br.com.desafio.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Payment {
    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("payment_items")
    private List<PaymentItem> paymentItems;
}