package com.ablhds.app.domain.dao;

import com.ablhds.app.domain.Veiculo;

import java.sql.SQLException;
import java.util.List;

public interface IVeiculoDAO {

    void insert(Veiculo veiculo) throws SQLException;

    void update(Veiculo veiculo) throws SQLException;

    void delete(Veiculo veiculo) throws SQLException;

    List<VeiculoDTO> findAll() throws SQLException;

    VeiculoDTO findByPlaca(String placa) throws SQLException;

    List<VeiculoDTO> findAllByPlaca() throws SQLException;

    List<VeiculoDTO> findAllByModelo() throws SQLException;

}
