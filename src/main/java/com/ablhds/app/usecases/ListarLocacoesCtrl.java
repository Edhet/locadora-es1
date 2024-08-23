package com.ablhds.app.usecases;

import com.ablhds.app.domain.*;

import java.sql.SQLException;
import java.util.List;

public class ListarLocacoesCtrl {
    private final LocacaoRepository repo;

    public ListarLocacoesCtrl(LocacaoRepository repo) {
        super();
        this.repo = repo;
    }

    public Resultado<List<Locacao>> ListarLocacoes() {
        try {
            var locacoes = repo.findAll();
            return Resultado.ok(locacoes);
        } catch (SQLException e) {
            return Resultado.erro(List.of(Erro.ERRO_BD));
        }
    }
}
