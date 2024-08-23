package com.ablhds.app.domain.dao;

import java.time.LocalDateTime;

public record LocacaoDTO(String id,
                         Long cpfCliente,
                         String placaVeiculo,
                         LocalDateTime dataHora) {
}
