package com.ablhds.app.ui;

import com.ablhds.app.usecases.ListarVeiculosCtrl;

public class ListarVeiculosPrt implements Presenter{

    private ListarVeiculosView view;
    private ListarVeiculosCtrl controller;

    public ListarVeiculosPrt(ListarVeiculosView view, ListarVeiculosCtrl controller) {
        super();
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void run() {
        String selecao = view.readData();

        if (selecao.equals("C")) {
            var resultado = controller.recuperarTodosVeiculosPorPlaca();
            if (resultado.sucesso())
                view.mostrarVeiculos(resultado.valor);
            else
                view.mostrarErro();
        } else if (selecao.equals("N")) {
            var resultado = controller.recuperarTodosVeiculosPorModelo();
            if (resultado.sucesso())
                view.mostrarVeiculos(resultado.valor);
            else
                view.mostrarErro();
        } else { // todo - prvavelmente qnd fizer o tratamento isso vai sair
            var resultado = controller.recuperarTodosVeiculos();
            if (resultado.sucesso())
                view.mostrarVeiculos(resultado.valor);
            else
                view.mostrarErro();
        }
    }

}
