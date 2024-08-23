package com.ablhds.app.ui;

import com.ablhds.app.domain.Erro;
import com.ablhds.app.usecases.CPFClienteRequest;
import com.ablhds.app.usecases.ExclusaoClienteCtrl;

import java.util.List;

public class ExclusaoClientePrt implements Presenter{
    private ExclusaoClienteView view;
    private ExclusaoClienteCtrl controller;

    public ExclusaoClientePrt(ExclusaoClienteView view, ExclusaoClienteCtrl controller) {
        super();
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void run() {
        Long cpf;
        List<Erro> erros;

        do {

            var data = view.readData();


            try {
                cpf = Long.parseLong(data.cpf());
            } catch (Exception ex) {
                cpf = null;
            }


            erros = controller.excluirCLiente(new CPFClienteRequest(cpf));



            if (erros != null)
                view.setErros(erros);
            else
                view.setSucesso();
        } while (erros != null);
    }
}
