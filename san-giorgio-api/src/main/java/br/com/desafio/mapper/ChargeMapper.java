package br.com.desafio.mapper;

import br.com.desafio.domain.model.Charge;
import br.com.desafio.dto.ChargeDTO;

public class ChargeMapper {

    public static ChargeDTO toDTO(Charge charge) {
        return ChargeDTO.builder()
                .id(charge.getId())
                .amount(charge.getAmount())
                .build();
    }

    public static Charge toEntity(ChargeDTO chargeDTO) {
        return new Charge(chargeDTO.getId(), chargeDTO.getAmount());
    }
}