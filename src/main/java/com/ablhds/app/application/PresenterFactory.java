package com.ablhds.app.application;


import com.ablhds.app.domain.ClienteRepository;
import com.ablhds.app.persistence.ClienteDAO;
import com.ablhds.app.ui.*;
import com.ablhds.app.usecases.CadastroClienteCtrl;
import com.ablhds.app.usecases.ListarClientesCtrl;

/**
 * Classe responsável por criar os presenters e sua estrutura
 */
public class PresenterFactory {

    /**
     * Tipo do presenter
     */
    public enum Type {
        MENU,
        CADASTRAR_CLIENTE,
        EXCLUIR_CLIENTE,
        LISTAR_CLIENTE
    }

    ;

    /**
     * Cria um presenter de acordo com o tipo solicitado
     *
     * @param type Tipo do presenter
     * @return Presenter
     */
    public static Presenter get(Type type) {
        switch (type) {
            case MENU -> {
                var view = new MenuView();

                return new MenuPresenter(view);
            }

            case CADASTRAR_CLIENTE -> {
                var repository = new ClienteRepository(new ClienteDAO());
                var view = new CadastroClienteView();
                var controller = new CadastroClienteCtrl(repository);

                return new CadastroClientePrt(view, controller);

            }

            case EXCLUIR_CLIENTE -> {
                return null;
            }

            case LISTAR_CLIENTE -> {
                var repository = new ClienteRepository(new ClienteDAO());
                var view = new ListarClientesView();
                var controller = new ListarClientesCtrl(repository);

                return new ListarClientesPrt(view, controller);
            }
        }
        ;
        return null;
    }
}
