package com.ablhds.app.domain;

public class VeiculoBuilder {
    private String placa;
    private String modelo;
    private String cor;
    private int ano;
    private double diaria;
    private int quilometragem;

    public VeiculoBuilder() {
    }

    public VeiculoBuilder withPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public VeiculoBuilder withModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public VeiculoBuilder withCor(String cor) {
        this.cor = cor;
        return this;
    }

    public VeiculoBuilder withAno(int ano) {
        this.ano = ano;
        return this;
    }

    public VeiculoBuilder withDiaria(double diaria) {
        this.diaria = diaria;
        return this;
    }

    public VeiculoBuilder withQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
        return this;
    }

    public Resultado<Veiculo> build() {
        return Veiculo.create(this.placa, this.modelo, this.cor, this.ano, this.diaria, this.quilometragem);
    }
}
