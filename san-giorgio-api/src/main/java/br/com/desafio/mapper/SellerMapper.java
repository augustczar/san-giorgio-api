package br.com.desafio.mapper;

import br.com.desafio.domain.model.Seller;
import br.com.desafio.dto.SellerDTO;

public class SellerMapper {

    public static SellerDTO toDTO(Seller seller) {
        return SellerDTO.builder()
                .sellerCode(seller.getSellerCode())
                .name(seller.getName())
                .build();
    }

    public static Seller toEntity(SellerDTO sellerDTO) {
        Seller seller = new Seller();
        seller.setSellerCode(sellerDTO.getSellerCode());
        seller.setName(sellerDTO.getName());
        return seller;
    }
}
