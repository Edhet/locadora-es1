package com.ablhds.app.usecases;

public record VeiculoRequest(String id,
                             String placa,
                             String modelo,
                             Integer ano,
                             Double diaria,
                             Integer quilometragem) {
}
