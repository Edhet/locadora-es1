package com.ablhds.app.domain;

import com.ablhds.app.domain.dao.IVeiculoDAO;
import com.ablhds.app.domain.dao.VeiculoDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VeiculoRepository implements Repository {
    private final IVeiculoDAO dao;

    public VeiculoRepository(IVeiculoDAO dao) {
        this.dao = dao;
    }

    public List<Veiculo> findAll() throws SQLException {
        var dtos = dao.findAll();

        var veiculos = new ArrayList<Veiculo>();

        for (var dto : dtos)
            veiculos.add(create(dto));

        return veiculos;
    }

    public Veiculo findByPlaca(String placa) throws SQLException {
        var dto = dao.findByPlaca(placa);

        if (dto != null)
            return create(dto);

        return null;
    }

    public List<Veiculo> findAllByPlaca() throws SQLException {
        // Busca todos os clientes do repositório
        var dtos = dao.findAllByPlaca();

        // Converte os DTOs vindo do repositório em clientes
        var veiculos = new ArrayList<Veiculo>();

        for (var dto : dtos)
            veiculos.add(create(dto));

        return veiculos;
    }

    public List<Veiculo> findAllByModelo() throws SQLException {
        // Busca todos os clientes do repositório
        var dtos = dao.findAllByModelo();

        // Converte os DTOs vindo do repositório em clientes
        var veiculos = new ArrayList<Veiculo>();

        for (var dto : dtos)
            veiculos.add(create(dto));

        return veiculos;
    }

    public void add(Veiculo veiculo) throws SQLException {
        if (veiculo.getId() == null) {
            veiculo.setId(UUID.randomUUID().toString());
            dao.insert(veiculo);
        } else
            dao.update(veiculo);
    }

    public void remove(String placa) throws SQLException {
        Veiculo veiculo = findByPlaca(placa);
        if (veiculo.getId() != null) {
            dao.delete(veiculo);

            veiculo.setId(null);
        }
    }

    private Veiculo create(VeiculoDTO dto) {
        var resultado = new VeiculoBuilder()
                .withPlaca(dto.placa())
                .withModelo(dto.modelo())
                .withAno(dto.ano())
                .withDiaria(dto.diaria())
                .withQuilometragem(dto.quilometragem())
                .build();

        var veiculo = resultado.valor;

        veiculo.setId(dto.id());

        return veiculo;
    }
}
