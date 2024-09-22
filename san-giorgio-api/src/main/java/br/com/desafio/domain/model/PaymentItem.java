package br.com.desafio.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class PaymentItem implements Serializable {

    private static final long serialVersionUID = -1075372108185262580L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "charge_id", nullable = false)
    private Charge charge;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)  // Aqui mapeamos a coluna de pagamento
    private Payment payment;

    @Column(name = "amount_paid", nullable = false, precision = 38, scale = 2)
    private BigDecimal amountPaid;
    
    private String paymentStatus;
}
