package br.com.desafio.domain.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@Table(name = "payments")
public class Payment implements Serializable{
	
    private static final long serialVersionUID = -5079865167432197784L;
	
    private String clientId;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private List<PaymentItem> paymentItems;
}