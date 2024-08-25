package com.ablhds.app.usecases;

import com.ablhds.app.domain.*;

import java.sql.SQLException;
import java.util.List;

public class ExclusaoVeiculoCtrl {
    private VeiculoRepository repo;

    public ExclusaoVeiculoCtrl(VeiculoRepository repo){
        super();
        this.repo = repo;
    }
    public List<Erro> excluirVeiculo(PlacaVeiculoRequest request) {
        try {
            var placa = Placa.create(request.placa());
            if (placa != null)
                repo.remove(placa.toString());

            return null;
        } catch (SQLException e) {
            return List.of(Erro.ERRO_BD);
        }
    }

}
