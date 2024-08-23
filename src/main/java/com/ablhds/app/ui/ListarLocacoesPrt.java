package com.ablhds.app.ui;


import com.ablhds.app.usecases.ListarLocacoesCtrl;

public class ListarLocacoesPrt implements Presenter{
    private ListarLocacoesView view;
    private ListarLocacoesCtrl controller;

    public ListarLocacoesPrt(ListarLocacoesView view, ListarLocacoesCtrl controller) {
        super();
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void run() {
        var resultado = controller.ListarLocacoes();
        if (resultado.sucesso())
            view.mostrarLocacoes(resultado.valor);
        else
            view.mostrarErro();
    }

}
