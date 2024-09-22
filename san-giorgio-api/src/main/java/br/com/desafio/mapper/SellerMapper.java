package br.com.desafio.mapper;

import br.com.desafio.domain.model.Seller;
import br.com.desafio.dto.SellerDTO;

public class SellerMapper {

    public static SellerDTO toDTO(Seller seller) {
        return SellerDTO.builder()
                .id(seller.getId())
                .name(seller.getName())
                .build();
    }

    public static Seller toEntity(SellerDTO sellerDTO) {
        return new Seller(sellerDTO.getId(), sellerDTO.getName());
    }
}