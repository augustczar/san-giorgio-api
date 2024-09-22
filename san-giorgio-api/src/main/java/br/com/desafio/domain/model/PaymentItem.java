package br.com.desafio.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "payment_items")
public class PaymentItem implements Serializable{
	
    private static final long serialVersionUID = -1075372108185262580L;
    
    @Id
    private String paymentId;

    private BigDecimal paymentValue;
    private String paymentStatus;

    @ManyToOne
    private Payment payment;
}