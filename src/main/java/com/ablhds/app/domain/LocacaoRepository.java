package com.ablhds.app.domain;

import com.ablhds.app.domain.dao.ILocacaoDAO;
import com.ablhds.app.domain.dao.LocacaoDTO;
import com.ablhds.app.domain.dao.ListagemLocacaoValoresDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LocacaoRepository implements Repository{
    private final ILocacaoDAO dao;

    public LocacaoRepository(ILocacaoDAO dao) {
        this.dao = dao;
    }

    public List<Locacao> findAll() throws SQLException {
        var dtos = dao.findAll();

        var locacoes = new ArrayList<Locacao>();

        for (var dto : dtos)
            locacoes.add(createWithAllValues(dto));

        return locacoes;
    }

    public Locacao findByCPF(Long cpf) throws SQLException {
        var dto = dao.findByCPF(cpf);

        if (dto != null)
            return createWithAllValues(dto);

        return null;
    }

    public Locacao findByPlaca(String placa) throws SQLException {
        var dto = dao.findByPlaca(placa);

        if (dto != null)
            return createWithAllValues(dto);

        return null;
    }


    public void add(Locacao locacao) throws SQLException {
        if (locacao.getId() == null) {
            locacao.setId(UUID.randomUUID().toString());
            dao.insert(locacao);
        } else
            dao.update(locacao);
    }

    public void remove(Locacao locacao) throws SQLException {
        if (locacao.getId() != null) {
            dao.delete(locacao);

            locacao.setId(null);
        }
    }


    private Locacao create(LocacaoDTO dto) {
        var resultado = new LocacaoBuilder()
                .withCPFCliente(dto.cpfCliente())
                .withPlacaVeiculo(dto.placaVeiculo())
                .withDataHora(dto.dataHora())
                .build(false);

        var locacao = resultado.valor;

        locacao.setId(dto.id());

        return locacao;
    }

    private Locacao createWithAllValues(ListagemLocacaoValoresDTO dto) {
        var resultado = new LocacaoBuilder()
                .withCPFCliente(dto.cpfCliente())
                .withNomeCliente(dto.nomeCliente())
                .withPlacaVeiculo(dto.placaVeiculo())
                .withModeloVeiculo(dto.modeloVeiculo())
                .withDataHora(dto.dataHora())
                .build(true);

        var locacao = resultado.valor;

        locacao.setId(dto.id());

        return locacao;
    }
}
