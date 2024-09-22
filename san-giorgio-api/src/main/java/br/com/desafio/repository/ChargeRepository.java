package br.com.desafio.repository;

import br.com.desafio.domain.model.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ChargeRepository extends JpaRepository<Charge, String> {
    List<Charge> findByAmountGreaterThan(BigDecimal amount);
}