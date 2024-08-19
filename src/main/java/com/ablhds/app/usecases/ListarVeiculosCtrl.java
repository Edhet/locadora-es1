package com.ablhds.app.usecases;

import com.ablhds.app.domain.*;

import java.sql.SQLException;
import java.util.List;

public class ListarVeiculosCtrl {
    private final VeiculoRepository repo;

    public ListarVeiculosCtrl(VeiculoRepository repo) {
        super();
        this.repo = repo;
    }

    public Resultado<List<Veiculo>> recuperarTodosVeiculos() {
        try {
            var veiculos = repo.findAll();

            return Resultado.ok(veiculos);
        } catch (SQLException e) {
            // Se ocorrer alguma exceção no BD, avisa
            return Resultado.erro(List.of(Erro.ERRO_BD));
        }
    }
}
