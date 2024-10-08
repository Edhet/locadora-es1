package com.ablhds.app.usecases;

import com.ablhds.app.domain.*;

import java.sql.SQLException;
import java.util.List;

public class CadastrarVeiculoCtrl {
    private final VeiculoRepository repo;

    public CadastrarVeiculoCtrl(VeiculoRepository repo) {
        super();
        this.repo = repo;
    }

    public List<Erro> incluirVeiculo(VeiculoRequest request) {
        try {
            var resultado = new VeiculoBuilder()
                    .withPlaca(request.placa())
                    .withModelo(request.modelo())
                    .withAno(request.ano())
                    .withDiaria(request.diaria())
                    .withQuilometragem(request.quilometragem())
                    .build();

            if (resultado.sucesso()) {
                var veiculo = resultado.valor;

                var outroVeiculo = repo.findByPlaca(veiculo.getPlaca().placa);

                if (outroVeiculo != null) {
                    return List.of(Erro.VEICULO_PLACA_DUPLICADA);
                }//todo

                repo.add(veiculo);

                return null;
            } else {
                return resultado.erros;
            }
        } catch (SQLException e) {
            return List.of(Erro.ERRO_BD);
        }
    }
}
