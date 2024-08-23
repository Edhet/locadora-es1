package com.ablhds.app.usecases;

import com.ablhds.app.domain.ClienteBuilder;
import com.ablhds.app.domain.ClienteRepository;
import com.ablhds.app.domain.Erro;

import java.sql.SQLException;
import java.util.List;

public class ExclusaoClienteCtrl {
    private final ClienteRepository repo;

    public ExclusaoClienteCtrl(ClienteRepository repo) {
        super();
        this.repo = repo;
    }

    public List<Erro> excluirCLiente(CPFClienteRequest request){
        try{
            var resultado = new ClienteBuilder()
                    .withCPF(request.cpf())
                    .build();

                if (resultado.sucesso()){
                    var cliente = resultado.valor;

                    if (cliente.getId() == null){
                        return List.of(Erro.CLIENTE_INEXISTENTE);
                    }

                    repo.remove(cliente.getCpf().valor);

                    return null;
                }
                else {
                    return resultado.erros;
                }


        } catch (SQLException e){
            return List.of(Erro.ERRO_BD);
        }

    }



}
