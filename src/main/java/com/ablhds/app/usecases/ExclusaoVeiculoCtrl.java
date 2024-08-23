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
            var resultado = new VeiculoBuilder()
                    .withPlaca(request.placa())
                    .build();

            if (resultado.sucesso()) {
                var veiculo = resultado.valor;

                if (veiculo.getId() == null) {
                    return List.of(Erro.VEICULO_INEXISTENTE);
                }

                repo.remove(veiculo.getPlaca().placa);

                return null;
            } else {
                return resultado.erros;
            }
        } catch (SQLException e) {
            return List.of(Erro.ERRO_BD);
        }
    }

}
