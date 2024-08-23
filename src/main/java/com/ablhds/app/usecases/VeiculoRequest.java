package com.ablhds.app.usecases;

public record VeiculoRequest(String placa,
                             String modelo,
                             Integer ano,
                             Double diaria,
                             Integer quilometragem) {
}
