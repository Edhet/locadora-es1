package com.ablhds.app.domain.dao;

import java.time.LocalDateTime;

public record ListagemLocacaoValoresDTO(String id,
                                        Long cpfCliente,
                                        String nomeCliente,
                                        String placaVeiculo,
                                        String modeloVeiculo,
                                        LocalDateTime dataHora) {
    //todo - renomear, nome tá um lixo
}
