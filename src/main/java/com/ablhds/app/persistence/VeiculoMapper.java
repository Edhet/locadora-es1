package com.ablhds.app.persistence;

import com.ablhds.app.domain.dao.VeiculoDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VeiculoMapper {
    public VeiculoDTO map(ResultSet rs) throws SQLException {
        return new VeiculoDTO(rs.getString("id"),
                rs.getString("placa"),
                rs.getString("modelo"),
                rs.getInt("ano"),
                rs.getDouble("diaria"),
                rs.getInt("quilometragem"));
    }
}
