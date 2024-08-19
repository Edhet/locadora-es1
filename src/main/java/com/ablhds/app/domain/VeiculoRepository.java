package com.ablhds.app.domain;

import com.ablhds.app.domain.dao.ClienteDTO;
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

    public void add(Veiculo veiculo) throws SQLException {
        if (veiculo.getId() == null) {
            veiculo.setId(UUID.randomUUID().toString());
            dao.insert(veiculo);
        } else
            dao.update(veiculo);
    }

    public void remove(Veiculo veiculo) throws SQLException {
        if (veiculo.getId() != null) {
            dao.delete(veiculo);

            veiculo.setId(null);
        }
    }

    /**
     * Cria um cliente a partir do ClienteDTO
     *
     * @param dto Dados do cliente vindos do BD
     * @return Cliente
     */
    private Veiculo create(VeiculoDTO dto) {
        // Usa o builder para construir o cliente com os dados vindos do BD
        var resultado = new VeiculoBuilder()
                .withPlaca(dto.placa())
                .withModelo(dto.modelo())
                .withAno(dto.ano())
                .withDiaria(dto.diaria())
                .withQuilometragem(dto.quilometragem())
                .build();

        // Assume que a criação foi bem sucedida,
        // pois os dados do BD devem estar consistentes
        var veiculo = resultado.valor;

        // Seta o ID do objeto, pois ele veio do BD
        veiculo.setId(dto.id());

        return veiculo;
    }
}
