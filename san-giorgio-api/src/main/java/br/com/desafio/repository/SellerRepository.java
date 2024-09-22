package br.com.desafio.repository;

import br.com.desafio.domain.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findByName(String name);

	boolean existsById(String clientId);
}