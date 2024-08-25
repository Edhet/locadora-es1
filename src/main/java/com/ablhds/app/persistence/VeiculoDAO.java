package com.ablhds.app.persistence;

import com.ablhds.app.domain.Placa;
import com.ablhds.app.domain.Veiculo;
import com.ablhds.app.domain.dao.VeiculoDTO;
import com.ablhds.app.domain.dao.IVeiculoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO implements IVeiculoDAO {
    @Override
    public void insert(Veiculo veiculo) throws SQLException {

        try (var conn = DBConnection.get();
            var stmt = conn.prepareStatement("insert into veiculo values (?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, veiculo.getId());
            stmt.setString(2, veiculo.getPlaca().placa);
            stmt.setString(3, veiculo.getModelo());
            stmt.setInt(4, veiculo.getAno());
            stmt.setDouble(5, veiculo.getDiaria());
            stmt.setInt(6, veiculo.getQuilometragem());

            stmt.execute();
        }
    }

    @Override
    public void update(Veiculo veiculo) throws SQLException {
        try (var conn = DBConnection.get();
            var stmt = conn.prepareStatement("update veiculo set placa=?, modelo=?, ano=?, diaria=?, quilometragem=? where id=?")) {

            stmt.setString(1, veiculo.getPlaca().placa);
            stmt.setString(2, veiculo.getModelo());
            stmt.setInt(3, veiculo.getAno());
            stmt.setDouble(4, veiculo.getDiaria());
            stmt.setInt(5, veiculo.getQuilometragem());
            stmt.setString(6, veiculo.getId());


            stmt.execute();
        }
    }

    @Override
    public void delete(Placa placa) throws SQLException {
        try (var conn = DBConnection.get();
             var stmt = conn.prepareStatement("delete from veiculo where veiculo.placa=?")) {

            stmt.setString(1, placa.toString());

            stmt.execute();
        }
    }

    @Override
    public List<VeiculoDTO> findAll() throws SQLException {

        try (var conn = DBConnection.get();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery("select * from veiculo")) {

            var mapper = new VeiculoMapper();
            var veiculos = new ArrayList<VeiculoDTO>();

            while (rs.next())
                veiculos.add(mapper.map(rs));

            return veiculos;
        }
    }

    @Override
    public VeiculoDTO findByPlaca(String placa) throws SQLException {

        try (var conn = DBConnection.get();
             var stmt = conn.prepareStatement("select * from veiculo where placa = ?")) {

            stmt.setString(1, placa);

            try (var rs = stmt.executeQuery()) {

                var mapper = new VeiculoMapper();

                if (rs.next())
                    return mapper.map(rs);

                return null;
            }
        }
    }

    @Override
    public List<VeiculoDTO> findAllByPlaca() throws SQLException {
        try (var conn = DBConnection.get();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery("select * from veiculos order by placa")) {

            var mapper = new VeiculoMapper();
            var veiculos = new ArrayList<VeiculoDTO>();

            // Para todos os regitros vindoos do BD, converte os dados
            // do ResultSet em DTO usando o mapper
            while (rs.next())
                veiculos.add(mapper.map(rs));

            return veiculos;
        }
    }

    @Override
    public List<VeiculoDTO> findAllByModelo() throws SQLException {
        try (var conn = DBConnection.get();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery("select * from veiculos order by modelo")) {

            var mapper = new VeiculoMapper();
            var veiculos = new ArrayList<VeiculoDTO>();


            while (rs.next())
                veiculos.add(mapper.map(rs));

            return veiculos;
        }
    }

}
