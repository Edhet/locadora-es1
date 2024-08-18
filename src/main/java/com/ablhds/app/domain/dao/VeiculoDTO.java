package com.ablhds.app.domain.dao;

public record VeiculoDTO(String id,
                        String placa,
                        String modelo,
                        Integer ano,
                        Double diaria,
                        Integer quilometragem) {
}
