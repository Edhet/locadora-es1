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
            var clientes = repo.findAll();

            return Resultado.ok(clientes);
        } catch (SQLException e) {
            return Resultado.erro(List.of(Erro.ERRO_BD));
        }
    }

    public Resultado<List<Veiculo>> recuperarTodosVeiculosPorPlaca() {
        try {
            var veiculos = repo.findAllByPlaca();

            return Resultado.ok(veiculos);
        } catch (SQLException e) {
            return Resultado.erro(List.of(Erro.ERRO_BD));
        }
    }

    public Resultado<List<Veiculo>> recuperarTodosVeiculosPorModelo() {
        try {
            var clientes = repo.findAllByModelo();

            return Resultado.ok(clientes);
        } catch (SQLException e) {
            return Resultado.erro(List.of(Erro.ERRO_BD));
        }
    }
}
