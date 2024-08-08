package com.ablhds.app.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela construção do cliente e dos demais objetos relacionados a ele
 */
public class ClienteBuilder {
    private Long cpf;
    private String nome;
    private LocalDate dtNasc;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private Long cep;
    private Integer ddd;
    private Long numeroTel;

    public ClienteBuilder() {
    }

    public ClienteBuilder withCPF(Long cpf) {
        this.cpf = cpf;
        return this;
    }

    public ClienteBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder withDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
        return this;
    }

    public ClienteBuilder withLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public ClienteBuilder withNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public ClienteBuilder withComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public ClienteBuilder withBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public ClienteBuilder withCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public ClienteBuilder withUF(String uf) {
        this.uf = uf;
        return this;
    }

    public ClienteBuilder withCEP(Long cep) {
        this.cep = cep;
        return this;
    }

    public ClienteBuilder withDDD(Integer ddd) {
        this.ddd = ddd;
        return this;
    }

    public ClienteBuilder withNumeroTel(Long numeroTel) {
        this.numeroTel = numeroTel;
        return this;
    }

    /**
     * Constrói o objeto cliente
     *
     * @return Objeto Cliente ou uma lista de códigos de erro
     */
    public Resultado<Cliente> build() {
        List<Erro> erros = new ArrayList<>();

        // 1 - Tenta construir o telefone
        var resultTelefone = Telefone.create(ddd, numeroTel);

        // Se falhou, copia os códigos de erro para a lista de erros
        if (resultTelefone.falha())
            erros.addAll(resultTelefone.erros);

        // 2 - Tenta construir o endereço
        var resultEndereco = Endereco.create(logradouro,
                numero,
                complemento,
                bairro,
                cidade,
                uf,
                cep);

        // Se falhou, copia os códigos de erro para a lista de erros
        if (resultEndereco.falha())
            erros.addAll(resultEndereco.erros);

        // 3 - Tenta construir o cliente
        var resultCliente = Cliente.create(cpf,
                nome,
                dtNasc,
                resultEndereco.valor,
                resultTelefone.valor);

        // Se falhou, copia os códigos de erro para a lista de erros
        if (resultCliente.falha())
            erros.addAll(resultCliente.erros);

        // Retorna o cliente ou a lista de códigos de erro
        return erros.isEmpty() ?
                Resultado.ok(resultCliente.valor) :
                Resultado.erro(erros);
    }

}
