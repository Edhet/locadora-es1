package com.ablhds.app.domain.dao;

import com.ablhds.app.domain.Locacao;

import java.sql.SQLException;
import java.util.List;

public interface ILocacaoDAO {
    void insert(Locacao locacao) throws SQLException;

    void update(Locacao locacao) throws SQLException;

    void delete(Locacao locacao) throws SQLException;

    List<ListagemLocacaoValoresDTO> findAll() throws SQLException;

    ListagemLocacaoValoresDTO findByCPF(Long cpf) throws SQLException;

    ListagemLocacaoValoresDTO findByPlaca(String placa) throws SQLException;

}
