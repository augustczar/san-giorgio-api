package br.com.desafio.repository;

import br.com.desafio.domain.model.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChargeRepository extends JpaRepository<Charge, Long> {
    List<Charge> findByAmountGreaterThan(BigDecimal amount);

	boolean existsById(String paymentId);

	Optional<Charge> findById(String paymentId);
}