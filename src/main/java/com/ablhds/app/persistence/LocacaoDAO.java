package com.ablhds.app.persistence;

import com.ablhds.app.domain.Locacao;
import com.ablhds.app.domain.dao.ILocacaoDAO;
import com.ablhds.app.domain.dao.ListagemLocacaoValoresDTO;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocacaoDAO implements ILocacaoDAO {
    @Override
    public void insert(Locacao locacao) throws SQLException {
        try (var conn = DBConnection.get();
             var stmt = conn.prepareStatement("insert into locacao values (?, ?, ?, ?)")) {

            var df = DateTimeFormatter.ofPattern("ddMMyyyyHHmm", Locale.getDefault());

            stmt.setString(1, locacao.getId());
            stmt.setString(2, locacao.getCpfCliente().toString());
            stmt.setString(3, locacao.getPlacaVeiculo().toString());
            stmt.setString(4, df.format(locacao.getDataHora()));

            stmt.execute();
        }
    }

    @Override
    public void update(Locacao locacao) throws SQLException {
        try (var conn = DBConnection.get(); //todo - n sei se tem q mudar data_hora no update, já q conta-se o valor da diária a partir da data de inclusão
             var stmt = conn.prepareStatement("update locacao set cpf_cliente=?, placa_veiculo=?, data_hora=? where id=?")) {

            var df = DateTimeFormatter.ofPattern("ddMMyyyyHHmm", Locale.getDefault());

            stmt.setString(1, locacao.getCpfCliente().toString());
            stmt.setString(2, locacao.getPlacaVeiculo().toString());
            stmt.setString(3, df.format(locacao.getDataHora()));
            stmt.setString(4, locacao.getId());

            stmt.execute();
        }
    }

    @Override
    public void delete(Locacao locacao) throws SQLException {
        try (var conn = DBConnection.get();
             var stmt = conn.prepareStatement("delete from locacao where id=?")) {

            stmt.setString(1, locacao.getId());

            stmt.execute();
        }
    }

    @Override
    public List<ListagemLocacaoValoresDTO> findAll() throws SQLException {
        try (var conn = DBConnection.get();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery("""
                 SELECT l.id, c.cpf, c.nome, v.placa, v.modelo, l.data_hora
                 FROM locacao l
                 JOIN clientes c ON l.cpf_cliente = c.cpf
                 JOIN veiculo v ON l.placa_veiculo = v.placa
             """)) {

            var mapper = new LocacaoMapper();
            var locacoes = new ArrayList<ListagemLocacaoValoresDTO>();

            while (rs.next())
                locacoes.add(mapper.map(rs));

            return locacoes;
        }
    }

    @Override
    public ListagemLocacaoValoresDTO findByCPF(Long cpf) throws SQLException {
        try (var conn = DBConnection.get();
             var stmt = conn.prepareStatement("select * from locacao where cpf_cliente = ?")) {

            stmt.setLong(1, cpf);

            try (var rs = stmt.executeQuery()) {

                var mapper = new LocacaoMapper();

                if (rs.next())
                    return mapper.map(rs);

                return null;
            }
        }
    }

    @Override
    public ListagemLocacaoValoresDTO findByPlaca(String placa) throws SQLException {
        try (var conn = DBConnection.get();
             var stmt = conn.prepareStatement("select * from locacao where placa_veiculo = ?")) {

            stmt.setString(1, placa);

            try (var rs = stmt.executeQuery()) {

                var mapper = new LocacaoMapper();


                if (rs.next())
                    return mapper.map(rs);

                return null;
            }
        }
    }
}
