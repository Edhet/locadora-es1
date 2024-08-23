package com.ablhds.app.ui;


import com.ablhds.app.usecases.ListarClientesCtrl;

public class ListarClientesPrt implements Presenter {

    private ListarClientesView view;
    private ListarClientesCtrl controller;

    public ListarClientesPrt(ListarClientesView view, ListarClientesCtrl controller) {
        super();
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void run() { //todo - tratar erro de input
        String selecao = view.readData();

        if (selecao.equals("C")){
            var resultado = controller.recuperarTodosClientesPorCPF();
            if (resultado.sucesso())
                view.mostrarClientes(resultado.valor);
            else
                view.mostrarErro();
        }
        else if (selecao.equals("N")){
            var resultado = controller.recuperarTodosClientesPorNome();
            if (resultado.sucesso())
                view.mostrarClientes(resultado.valor);
            else
                view.mostrarErro();
        }
        else { // todo - acho q qnd fizer o tratamento isso vai sair
            var resultado = controller.recuperarTodosClientes();
            if (resultado.sucesso())
                view.mostrarClientes(resultado.valor);
            else
                view.mostrarErro();
        }


    }

}





