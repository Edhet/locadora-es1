package com.ablhds.app.ui;

import com.ablhds.app.domain.Erro;
import com.ablhds.app.usecases.ExclusaoVeiculoCtrl;
import com.ablhds.app.usecases.PlacaVeiculoRequest;

import java.util.List;

public class ExclusaoVeiculoPrt implements Presenter{
    private ExclusaoVeiculoView view;
    private ExclusaoVeiculoCtrl controller;

    public ExclusaoVeiculoPrt(ExclusaoVeiculoView view, ExclusaoVeiculoCtrl controller) {
        super();
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void run() {
        String placa;
        List<Erro> erros;

        do {
            var data = view.readData();
            placa = data.placa();

            erros = controller.excluirVeiculo(new PlacaVeiculoRequest(placa));

            if (erros != null)
                view.setErros(erros);
            else
                view.setSucesso();
        } while (erros != null);
    }
}
