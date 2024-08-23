package com.ablhds.app.ui;


import com.ablhds.app.application.PresenterFactory;

public class MenuPresenter implements Presenter {

    private final MenuView view;

    public MenuPresenter(MenuView view) {
        super();
        this.view = view;
    }

    @Override
    public void run() {
        MenuView.Opcao opcao;
        boolean fim = false;

        while (!fim) {
            opcao = view.getOpcao();

            switch (opcao) {
                case CADASTRAR_CLIENTE -> {
                    var presenter = PresenterFactory.get(PresenterFactory.Type.CADASTRAR_CLIENTE);
                    presenter.run();
                }
                case LISTAR_CLIENTE -> {
                    var presenter = PresenterFactory.get(PresenterFactory.Type.LISTAR_CLIENTE);
                    presenter.run();
                }
                case EXCLUIR_CLIENTE -> {
                    var presenter = PresenterFactory.get(PresenterFactory.Type.EXCLUIR_CLIENTE);
                    presenter.run();
                }
                case CADASTRAR_VEICULO -> {
                    var presenter = PresenterFactory.get(PresenterFactory.Type.CADASTRAR_VEICULO);
                    presenter.run();
                }
                case EXCLUIR_VEICULO -> {
                    var presenter = PresenterFactory.get(PresenterFactory.Type.EXCLUIR_VEICULO);
                    presenter.run();
                }
                case LISTAR_VEICULO -> {
                    var presenter = PresenterFactory.get(PresenterFactory.Type.LISTAR_VEICULOS);
                    presenter.run();
                }
                case LOCAR_VEICULO -> {
                    var presenter = PresenterFactory.get(PresenterFactory.Type.LOCAR_VEICULO);
                    presenter.run();
                }
                case LISTAR_LOCACAO -> {
                    var presenter = PresenterFactory.get(PresenterFactory.Type.LISTAR_LOCACOES);
                    presenter.run();
                }
                case FIM -> fim = true;
            }
        }
    }
}
