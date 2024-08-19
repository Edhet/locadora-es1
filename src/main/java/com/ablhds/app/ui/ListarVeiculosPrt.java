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
            var resultado = controller.recuperarTodosVeiculos();

            if (resultado.sucesso())
                view.mostrarVeiculos(resultado.valor);
            else
                view.mostrarErro();
        }

    }
