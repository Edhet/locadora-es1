package com.ablhds.app.ui;

import com.ablhds.app.domain.Erro;
import com.ablhds.app.usecases.LocacaoRequest;
import com.ablhds.app.usecases.LocarVeiculoCtrl;

import java.time.LocalDateTime;
import java.util.List;

public class LocarVeiculoPrt implements Presenter{

    private LocarVeiculoView view;
    private LocarVeiculoCtrl controller;

    public LocarVeiculoPrt(LocarVeiculoView view, LocarVeiculoCtrl controller) {
        super();
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void run() {
        Long cpf;
        LocalDateTime dataHora;
        List<Erro> erros;

        do {

            var data = view.readData();


            try {
                cpf = Long.parseLong(data.cpfCliente());
            } catch (Exception ex) {
                cpf = null;
            }

            dataHora = data.dataHora();


            erros = controller.locarVeiculo(new LocacaoRequest(cpf, data.placaVeiculo(), dataHora));


            if (erros != null)
                view.setErros(erros);
            else
                view.setSucesso();
        } while (erros != null);
    }
}
