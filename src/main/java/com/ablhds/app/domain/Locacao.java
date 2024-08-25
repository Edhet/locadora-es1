package com.ablhds.app.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Locacao extends Persistent{
    private CPF cpfCliente;
    private String nomeCliente;
    private Placa placaVeiculo;
    private String modeloVeiculo;
    private LocalDateTime dataHora;

    public Locacao(CPF cpfCliente, Placa placaVeiculo, LocalDateTime dataHora) {
        super();
        this.cpfCliente = cpfCliente;
        this.placaVeiculo = placaVeiculo;
        this.dataHora = dataHora;
    }

    public Locacao(CPF cpfCliente, String nomeCliente, Placa placaVeiculo, String modeloVeiculo, LocalDateTime dataHora) {
        super();
        this.cpfCliente = cpfCliente;
        this.placaVeiculo = placaVeiculo;
        this.dataHora = dataHora;
    }

    public static Resultado<Locacao> create(Long cpfCliente, String placaVeiculo, LocalDateTime data_hora) {
        //todo - tratamento de erros
        List<Erro> erros = new ArrayList<>();
        CPF cpfEntity = CPF.create(cpfCliente);
        Placa placaEntity = Placa.create(placaVeiculo);

        //todo - acho q está errada a verificação
        if (cpfEntity == null){
            erros.add(Erro.CPF_INVALIDO);
        }
        if (placaEntity == null)
            erros.add(Erro.VEICULO_PLACA_INVALIDA);

        if (data_hora == null) {
            erros.add(Erro.DATA_INVALIDA);
        }


        return erros.isEmpty() ? Resultado.ok(new Locacao(cpfEntity, placaEntity, data_hora)) : Resultado.erro(erros);
    }

    public static Resultado<Locacao> create(Long cpfCliente, String nomeCliente, String placaVeiculo, String modeloVeiculo, LocalDateTime dataHora) {
        //todo - melhorar tratamento de erros se for o caso
        List<Erro> erros = new ArrayList<>();
        CPF cpfEntity = CPF.create(cpfCliente);
        Placa placaEntity = Placa.create(placaVeiculo);

        //todo - acho q está errada a verificação
        // estava mesmo bobão..
        if (cpfEntity == null){
            erros.add(Erro.CPF_INVALIDO);
        }
        if (placaEntity == null)
            erros.add(Erro.VEICULO_PLACA_INVALIDA);

        if (dataHora == null) {
            erros.add(Erro.DATA_INVALIDA);
        }


        return erros.isEmpty() ? Resultado.ok(new Locacao(cpfEntity, nomeCliente, placaEntity, modeloVeiculo, dataHora)) : Resultado.erro(erros);
    }

    public CPF getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(CPF cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Placa getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(Placa placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }
}
