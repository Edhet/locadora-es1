package com.ablhds.app.persistence;


import com.ablhds.app.domain.dao.ClienteDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe responsável por mapear os dados vindos do BD (ResultSet) para o DTO
 */
public class ClienteMapper {

    /**
     * Mapeia os dados do ResultSet no DTO
     *
     * @param rs ResultSet com os dados
     * @return ClienteDTO
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    public ClienteDTO map(ResultSet rs) throws SQLException {
        var df = DateTimeFormatter.ofPattern("yyyyMMdd");

        return new ClienteDTO(rs.getString("id"),
                rs.getLong("cpf"),
                rs.getString("nome"),
                LocalDate.from(df.parse(rs.getString("datanasc"))),
                rs.getString("logradouro"),
                rs.getString("numero"),
                rs.getString("complemento"),
                rs.getString("bairro"),
                rs.getString("cidade"),
                rs.getString("uf"),
                rs.getLong("cep"),
                rs.getInt("ddd"),
                rs.getLong("telefone"));
    }
}
