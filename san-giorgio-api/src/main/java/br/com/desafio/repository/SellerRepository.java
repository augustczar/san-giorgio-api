package br.com.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.domain.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    boolean existsBySellerCode(String sellerCode);

    Optional<Seller> findBySellerCode(String sellerCode);
}
