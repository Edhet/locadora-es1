package com.ablhds.app.persistence;

import com.ablhds.app.domain.Cliente;
import com.ablhds.app.domain.dao.ClienteDTO;
import com.ablhds.app.domain.dao.IClienteDAO;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    /**
     * Insere um cliente no BD
     *
     * @param cliente Cliente a ser inserido
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    @Override
    public void insert(Cliente cliente) throws SQLException {

        // Abre uma conexão com o BD
        // Cria um statement
        try (var conn = DBConnection.get();
             var stmt = conn.prepareStatement("insert into clientes values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            // Define os valores dos parâmetros
            var df = DateTimeFormatter.ofPattern("yyyyMMdd");

            stmt.setString(1, cliente.getId());
            stmt.setLong(2, cliente.getCpf().valor);
            stmt.setString(3, cliente.getNome());
            stmt.setString(4, df.format(cliente.getDtNasc()));
            stmt.setString(5, cliente.getEndereco().getLogradouro());
            stmt.setString(6, cliente.getEndereco().getNumero());
            stmt.setString(7, cliente.getEndereco().getComplemento());
            stmt.setString(8, cliente.getEndereco().getBairro());
            stmt.setString(9, cliente.getEndereco().getCidade());
            stmt.setString(10, cliente.getEndereco().getUf().name());
            stmt.setLong(11, cliente.getEndereco().getCep());
            stmt.setInt(12, cliente.getTelefone().getDdd());
            stmt.setLong(13, cliente.getTelefone().getNumero());

            // Executar o comando
            stmt.execute();
        }
    }

    /**
     * Atualiza um cliente no BD
     *
     * @param cliente Cliente a ser atualizado
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    @Override
    public void update(Cliente cliente) throws SQLException {

        // Abre uma conexão com o BD
        // Cria um statement
        try (var conn = DBConnection.get();
             var stmt = conn.prepareStatement("update clientes set cpf=?, nome=?, datanasc=?, logradouro=?, numero=?, "
                     + "complemento=?, bairro=?, cidade=?, uf=?, cep=?, ddd=?, telefone=? where id=?")) {

            // Define os valores dos parâmetros
            var df = DateTimeFormatter.ofPattern("yyyyMMdd");

            stmt.setLong(1, cliente.getCpf().valor);
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, df.format(cliente.getDtNasc()));
            stmt.setString(4, cliente.getEndereco().getLogradouro());
            stmt.setString(5, cliente.getEndereco().getNumero());
            stmt.setString(6, cliente.getEndereco().getComplemento());
            stmt.setString(7, cliente.getEndereco().getBairro());
            stmt.setString(8, cliente.getEndereco().getCidade());
            stmt.setString(9, cliente.getEndereco().getUf().name());
            stmt.setLong(10, cliente.getEndereco().getCep());
            stmt.setInt(11, cliente.getTelefone().getDdd());
            stmt.setLong(12, cliente.getTelefone().getNumero());
            stmt.setString(13, cliente.getId());

            // Executa o comando
            stmt.execute();
        }
    }

    /**
     * Deleta um cliente do BD
     *
     * @param cliente Cliente a ser deletado
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    @Override
    public void delete(Cliente cliente) throws SQLException {

        // Abre uma conexão com o BD
        // Cria um statement
        try (var conn = DBConnection.get();
             var stmt = conn.prepareStatement("delete from clientes where id=?")) {

            // Define ID do comando
            stmt.setString(1, cliente.getId());

            // Executa o comando
            stmt.execute();
        }
    }

    /**
     * Retorna todos os clientes do BD
     *
     * @return Lista de DTOs com os dados dos clientes
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    @Override
    public List<ClienteDTO> findAll() throws SQLException {

        // Abre uma conexão com o BD
        // Cria um statement
        // Executa o comando que retorna um ResultSet
        try (var conn = DBConnection.get();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery("select * from clientes")) {

            var mapper = new ClienteMapper();
            var clientes = new ArrayList<ClienteDTO>();

            // Para todos os regitros vindoos do BD, converte os dados
            // do ResultSet em DTO usando o mapper
            while (rs.next())
                clientes.add(mapper.map(rs));

            return clientes;
        }
    }

    /**
     * Retorna um cliente baseado no CPF
     *
     * @param cpf CPF do cliente
     * @return DTO com os dados do cliente
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    @Override
    public ClienteDTO findByCPF(Long cpf) throws SQLException {

        // Abre uma conexão com o BD
        // Cria um statement
        try (var conn = DBConnection.get();
             var stmt = conn.prepareStatement("select * from clientes where cpf = ?")) {

            // Define o CPF do comando
            stmt.setLong(1, cpf);

            // Executa o comando que retorna um ResultSet
            try (var rs = stmt.executeQuery()) {

                var mapper = new ClienteMapper();

                // Se existe um registro, converte os dados
                // do ResultSet em DTO usando o mapper
                if (rs.next())
                    return mapper.map(rs);

                // Se não existe, retorna nulo
                return null;
            }
        }
    }

    @Override
    public List<ClienteDTO> findAllByCPF() throws SQLException {
        try (var conn = DBConnection.get();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery("select * from clientes order by cpf")) {

            var mapper = new ClienteMapper();
            var clientes = new ArrayList<ClienteDTO>();


            while (rs.next())
                clientes.add(mapper.map(rs));

            return clientes;
        }
    }

    @Override
    public List<ClienteDTO> findAllByNome() throws SQLException {
        try (var conn = DBConnection.get();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery("select * from clientes order by nome")) {

            var mapper = new ClienteMapper();
            var clientes = new ArrayList<ClienteDTO>();


            while (rs.next())
                clientes.add(mapper.map(rs));

            return clientes;
        }
    }
}
