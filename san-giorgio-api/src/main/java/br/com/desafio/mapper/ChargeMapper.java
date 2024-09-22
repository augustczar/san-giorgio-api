package br.com.desafio.mapper;

import br.com.desafio.domain.model.Charge;
import br.com.desafio.dto.ChargeDTO;

public class ChargeMapper {

    public static ChargeDTO toDTO(Charge charge) {
        return ChargeDTO.builder()
                .chargeCode(charge.getChargeCode())
                .amount(charge.getAmount())
                .build();
    }

    public static Charge toEntity(ChargeDTO chargeDTO) {
        Charge charge = new Charge();
        charge.setChargeCode(chargeDTO.getChargeCode());
        charge.setAmount(chargeDTO.getAmount());
        return charge;
    }
}
