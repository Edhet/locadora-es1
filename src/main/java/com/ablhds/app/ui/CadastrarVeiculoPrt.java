package com.ablhds.app.ui;

import com.ablhds.app.domain.Erro;
import com.ablhds.app.usecases.CadastrarVeiculoCtrl;
import com.ablhds.app.usecases.VeiculoRequest;

import java.util.List;

public class CadastrarVeiculoPrt implements Presenter{
    private CadastrarVeiculoView view;
    private CadastrarVeiculoCtrl controller;

    public CadastrarVeiculoPrt(CadastrarVeiculoView view, CadastrarVeiculoCtrl controller) {
        super();
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void run() {
        Integer ano, quilometragem;
        Double diaria;
        List<Erro> erros;

        do {
            // 1 - Lê os dados da view

            var data = view.readData();

            // 2 - Converte os dados

            try {
                diaria = Double.parseDouble(data.diaria());
            } catch (Exception ex) {
                diaria = null;
            }
            try {
                ano = Integer.parseInt(data.ano());
            } catch (Exception ex) {
                ano = null;
            }
            try {
                quilometragem = Integer.parseInt(data.quilometragem());
            } catch (Exception ex) {
                quilometragem = null;
            }

            // 3 - Entrega os dados para o controller para processar o cadastro

            erros = controller.incluirVeiculo(new VeiculoRequest(data.placa(), data.modelo(), ano, diaria, quilometragem));

            // 4 - Verificar o status do processamento

            if (erros != null)
                view.setErros(erros);
            else
                view.setSucesso();
        } while (erros != null);
    }
}
