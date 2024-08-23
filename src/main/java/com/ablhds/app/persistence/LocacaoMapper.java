package com.ablhds.app.persistence;

import com.ablhds.app.domain.dao.ListagemLocacaoValoresDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocacaoMapper {
    public ListagemLocacaoValoresDTO map(ResultSet rs) throws SQLException {

        var df = DateTimeFormatter.ofPattern("ddMMyyyyHHmm", Locale.getDefault());

        return new ListagemLocacaoValoresDTO(rs.getString("id"),
                rs.getLong("cpfCliente"),
                rs.getString("nomeCliente"),
                rs.getString("placaVeiculo"),
                rs.getString("modeloVeiculo"),
                LocalDateTime.from(df.parse(rs.getString("dataHora"))));
    }
}
