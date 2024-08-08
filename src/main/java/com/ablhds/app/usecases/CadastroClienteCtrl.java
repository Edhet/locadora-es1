package com.ablhds.app.usecases;

import com.ablhds.app.domain.Cliente;
import com.ablhds.app.domain.ClienteRepository;
import com.ablhds.app.domain.ClienteBuilder;
import com.ablhds.app.domain.Erro;

import java.sql.SQLException;
import java.util.List;

/**
 * Classe que implementa a funcionalidade de cadastro de clientes
 */
public class CadastroClienteCtrl {

    private final ClienteRepository repo;

    public CadastroClienteCtrl(ClienteRepository repo) {
        super();
        this.repo = repo;
    }

    /**
     * Cadastra um cliente
     *
     * @param request Dados do cliente
     * @return Lista de códigos de erro ou null em caso de sucesso
     */
    public List<Erro> cadastrarCliente(ClienteRequest request) {

        try {
            // 1 - Tenta construir o cliente usando o builder
            var resultado = new ClienteBuilder()
                    .withCPF(request.cpf())
                    .withNome(request.nome())
                    .withDtNasc(request.dtNasc())
                    .withLogradouro(request.logradouro())
                    .withNumero(request.numero())
                    .withComplemento(request.complemento())
                    .withBairro(request.bairro())
                    .withCidade(request.cidade())
                    .withUF(request.uf())
                    .withCEP(request.cep())
                    .withDDD(request.ddd())
                    .withNumeroTel(request.numeroTel())
                    .build();

            // 2 - Verifica se teve sucesso ou não
            if (resultado.sucesso()) {
                var cliente = resultado.valor;

                // 3 - Verifica se tem outro cliente com o mesmo CPF
                var outroCliente = repo.findByCPF(cliente.getCpf().valor);

                if (outroCliente != null) {
                    return List.of(Erro.CPF_JA_EXISTENTE);
                }

                // 4 - Salva o cliente
                repo.add(cliente);

                // Avisa que não tem erro
                return null;
            } else {
                // Retorna os códigos de erro
                return resultado.erros;
            }
        } catch (SQLException e) {
            // Se ocorrer alguma exceção no BD, avisa
            return List.of(Erro.ERRO_BD);
        }
    }
}
