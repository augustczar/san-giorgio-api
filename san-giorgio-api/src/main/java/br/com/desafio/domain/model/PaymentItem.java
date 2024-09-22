package br.com.desafio.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class PaymentItem implements Serializable{
	
    private static final long serialVersionUID = -1075372108185262580L;
    
	@JsonProperty("payment_id")
    private String paymentId;
    @JsonProperty("payment_value")
    private BigDecimal paymentValue;
    @JsonProperty("payment_status")
    private String paymentStatus;
}