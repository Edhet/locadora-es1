package com.ablhds.app.usecases;

import com.ablhds.app.domain.*;

import java.sql.SQLException;
import java.util.List;

public class LocarVeiculoCtrl {
    private final LocacaoRepository repo;

    public LocarVeiculoCtrl(LocacaoRepository repo) {
        super();
        this.repo = repo;
    }
    public List<Erro> locarVeiculo(LocacaoRequest request) {
        try {
            var resultado = new LocacaoBuilder()
                    .withCPFCliente(request.cpfCliente())
                    .withPlacaVeiculo(request.placaVeiculo())
                    .withDataHora(request.dataHora())
                    .build(false);

            if (resultado.sucesso()) {
                var locacao = resultado.valor;

                var outroCliente = repo.findByCPF(locacao.getCpfCliente().valor);
                var outroVeiculo = repo.findByPlaca(locacao.getPlacaVeiculo().placa);

                if (outroCliente != null || outroVeiculo != null) {
                    return List.of(Erro.VEICULO_JA_ALOCADO);
                }

                if (locacao.getCpfCliente() == null){
                    return List.of(Erro.CLIENTE_INEXISTENTE);
                }

                if (locacao.getPlacaVeiculo() == null){
                    return List.of(Erro.VEICULO_INEXISTENTE);
                }

                repo.add(locacao);

                return null;
            } else {
                return resultado.erros;
            }
        } catch (SQLException e) {
            return List.of(Erro.ERRO_BD);
        }
    }


}
