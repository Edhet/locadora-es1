package com.ablhds.app.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Veiculo extends Persistent {
    private Placa placa;
    private String modelo;
    private String cor;
    private int ano;
    private double diaria;
    private int quilometragem;

    public Veiculo(Placa placa, String modelo, String cor, int ano, double diaria, int quilometragem) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.diaria = diaria;
        this.quilometragem = quilometragem;
    }

    public static Resultado<Veiculo> create(String placa, String modelo, String cor, int ano, double diaria, int quilometragem) {
        List<Erro> erros = new ArrayList<>();

        Placa placaEntity = Placa.create(placa);
        if (placaEntity == null)
            erros.add(Erro.VEICULO_PLACA_INVALIDA);

        int modeloLen = modelo.length();
        if (modeloLen < 2 || modeloLen > 30)
            erros.add(Erro.VEICULO_MODELO_INVALIDO);

        if (ano < 2000 || ano > LocalDate.now().getYear())
            erros.add(Erro.VEICULO_ANO_INVALIDO);

        if (diaria < 0.0)
            erros.add(Erro.VEICULO_DIARIA_INVALIDA);

        if (quilometragem < 0)
            erros.add(Erro.VEICULO_QUILOMETRAGEM_INVALIDA);

        // TODO: Checar por veículos com mesma placa

        return erros.isEmpty() ? Resultado.ok(new Veiculo(placaEntity, modelo, cor, ano, diaria, quilometragem)) : Resultado.erro(erros);
    }

    public Placa getPlaca() {
        return placa;
    }

    public void setPlaca(Placa placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }
}
