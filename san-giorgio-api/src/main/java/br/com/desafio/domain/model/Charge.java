package br.com.desafio.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "charges")
public class Charge implements Serializable {
		
    private static final long serialVersionUID = 152206435447184649L;
	    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "charge_code", nullable = false)
    private String chargeCode;

    @Column(nullable = false, precision = 38, scale = 2)
    private BigDecimal amount;
}
