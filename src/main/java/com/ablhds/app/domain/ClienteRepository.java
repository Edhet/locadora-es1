package com.ablhds.app.domain;

import com.ablhds.app.domain.dao.ClienteDTO;
import com.ablhds.app.domain.dao.IClienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Classe que representa um repositório de clientes.
 * A partir dessa classe os clientes são armazenados ou recuperados do BD
 */
public class ClienteRepository implements Repository {
    private final IClienteDAO dao;

    public ClienteRepository(IClienteDAO dao) {
        this.dao = dao;
    }

    /**
     * Retorna todos os clientes
     *
     * @return Lista de clientes
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    public List<Cliente> findAll() throws SQLException {
        // Busca todos os clientes do repositório
        var dtos = dao.findAll();

        // Converte os DTOs vindo do repositório em clientes
        var clientes = new ArrayList<Cliente>();

        for (var dto : dtos)
            clientes.add(create(dto));

        return clientes;
    }

    /**
     * Retorna  um cliente com base no CPF
     *
     * @param cpf CPF a ser buscado
     * @return Cliente ou null, se não existir
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    public Cliente findByCPF(Long cpf) throws SQLException {
        // Busca o cliente no repositório
        var dto = dao.findByCPF(cpf);

        // Se existe, converte o DTO em cliente e retorna
        if (dto != null)
            return create(dto);

        // Se não existe, retorna nulo
        return null;
    }

    /**
     * Adiciona/atualiza um cliente no repositório
     *
     * @param cliente a ser inserido/atualizado
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    public void add(Cliente cliente) throws SQLException {
        // Se o cliebte NÃO tem ID, então NÃO veio do BD
        if (cliente.getId() == null) {
            // Cria um ID artificial baseado no UUID
            cliente.setId(UUID.randomUUID().toString());

            // Insere o cliente no BD
            dao.insert(cliente);
        } else
            // Cliente já existe: atualiza no BD
            dao.update(cliente);
    }

    /**
     * Remove um cliente do repositório
     *
     * @param cliente Cliente a ser removido
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    public void remove(Cliente cliente) throws SQLException {
        // Se cliente TEM ID, então deleta do BD
        if (cliente.getId() != null) {
            dao.delete(cliente);

            // Seta o ID do objeto para nulo, porque ele não está mais no BD
            cliente.setId(null);
        }
    }

    /**
     * Cria um cliente a partir do ClienteDTO
     *
     * @param dto Dados do cliente vindos do BD
     * @return Cliente
     */
    private Cliente create(ClienteDTO dto) {
        // Usa o builder para construir o cliente com os dados vindos do BD
        var resultado = new ClienteBuilder()
                .withCPF(dto.cpf())
                .withNome(dto.nome())
                .withDtNasc(dto.dtNasc())
                .withLogradouro(dto.logradouro())
                .withNumero(dto.numero())
                .withComplemento(dto.complemento())
                .withBairro(dto.bairro())
                .withCidade(dto.cidade())
                .withUF(dto.uf())
                .withCEP(dto.cep())
                .withDDD(dto.ddd())
                .withNumeroTel(dto.numeroTel())
                .build();

        // Assume que a criação foi bem sucedida,
        // pois os dados do BD devem estar consistentes
        var cliente = resultado.valor;

        // Seta o ID do objeto, pois ele veio do BD
        cliente.setId(dto.id());

        return cliente;
    }
}
