package com.ablhds.app.ui;

import java.time.LocalDateTime;

public record LocacaoData(String cpfCliente,
                          String placaVeiculo,
                          LocalDateTime dataHora) {
}
