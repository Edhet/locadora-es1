package com.ablhds.app.domain;

import java.time.LocalDateTime;

public class LocacaoBuilder {
    private Long cpfCliente;
    private String nomeCliente;
    private String placaVeiculo;
    private String modeloVeiculo;
    private LocalDateTime dataHora;

    public LocacaoBuilder() {
    }

    public LocacaoBuilder withCPFCliente(Long cpfCliente) {
        this.cpfCliente = cpfCliente;
        return this;
    }
    public LocacaoBuilder withNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        return this;
    }
    public LocacaoBuilder withPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
        return this;
    }
    public LocacaoBuilder withModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
        return this;
    }
    public LocacaoBuilder withDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
        return this;
    }
    public Resultado<Locacao> build(boolean complete) {
        if (complete) return Locacao.create(this.cpfCliente, this.nomeCliente, this.placaVeiculo, this.modeloVeiculo, this.dataHora);

        return Locacao.create(this.cpfCliente, this.placaVeiculo, this.dataHora);
    }


}
