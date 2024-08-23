package com.ablhds.app.application;


import com.ablhds.app.domain.ClienteRepository;
import com.ablhds.app.domain.LocacaoRepository;
import com.ablhds.app.domain.VeiculoRepository;
import com.ablhds.app.persistence.ClienteDAO;
import com.ablhds.app.persistence.LocacaoDAO;
import com.ablhds.app.persistence.VeiculoDAO;
import com.ablhds.app.ui.*;
import com.ablhds.app.usecases.*;

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
        LISTAR_CLIENTE,
        CADASTRAR_VEICULO,
        EXCLUIR_VEICULO,
        LISTAR_VEICULOS,
        LOCAR_VEICULO,
        LISTAR_LOCACOES
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
                var repository = new ClienteRepository(new ClienteDAO());
                var view = new ExclusaoClienteView();
                var controller = new ExclusaoClienteCtrl(repository);

                return new ExclusaoClientePrt(view, controller);
            }

            case LISTAR_CLIENTE -> {
                var repository = new ClienteRepository(new ClienteDAO());
                var view = new ListarClientesView();
                var controller = new ListarClientesCtrl(repository);

                return new ListarClientesPrt(view, controller);
            }

            case CADASTRAR_VEICULO -> {
                var repository = new VeiculoRepository(new VeiculoDAO());
                var view = new CadastrarVeiculoView();
                var controller = new CadastrarVeiculoCtrl(repository);

                return new CadastrarVeiculoPrt(view, controller);
            }

            case EXCLUIR_VEICULO -> {
                var repository = new VeiculoRepository(new VeiculoDAO());
                var view = new ExclusaoVeiculoView();
                var controller = new ExclusaoVeiculoCtrl(repository);

                return new ExclusaoVeiculoPrt(view, controller);
            }

            case LISTAR_VEICULOS -> {
                var repository = new VeiculoRepository(new VeiculoDAO());
                var view = new ListarVeiculosView();
                var controller = new ListarVeiculosCtrl(repository);

                return new ListarVeiculosPrt(view, controller);
            }

            case LOCAR_VEICULO -> {
                var repository = new LocacaoRepository(new LocacaoDAO());
                var view = new LocarVeiculoView();
                var controller = new LocarVeiculoCtrl(repository);

                return new LocarVeiculoPrt(view, controller);
            }

            case LISTAR_LOCACOES -> {
                var repository = new LocacaoRepository(new LocacaoDAO());
                var view = new ListarLocacoesView();
                var controller = new ListarLocacoesCtrl(repository);

                return new ListarLocacoesPrt(view, controller);
            }

        }
        ;
        return null;
    }
}
