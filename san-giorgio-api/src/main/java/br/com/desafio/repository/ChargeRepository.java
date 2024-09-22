package br.com.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.domain.model.Charge;

@Repository
public interface ChargeRepository extends JpaRepository<Charge, Long> {

    boolean existsByChargeCode(String chargeCode);

    Optional<Charge> findByChargeCode(String chargeCode);
}
