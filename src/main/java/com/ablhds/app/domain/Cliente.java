package com.ablhds.app.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um cliente
 */
public class Cliente extends Persistent {
    private CPF cpf;
    private String nome;
    private LocalDate dtNasc;
    private Endereco endereco;
    private Telefone telefone;

    /**
     * Construtor privado que obriga a criar o objeto usando o método 'create'
     *
     * @param cpf      CPF
     * @param nome     Nome
     * @param dtNasc   Data de nascimento
     * @param endereco Endereço
     * @param telefone Telefone
     */
    private Cliente(CPF cpf, String nome, LocalDate dtNasc, Endereco endereco, Telefone telefone) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    /**
     * Valida os dados e cria um cliente
     *
     * @param numeroCPF CPF
     * @param nome      Nome
     * @param dtNasc    Data de nascimento
     * @param endereco  Endereço
     * @param telefone  Telefone
     * @return Cliente ou lista de códigos de erro
     */
    public static Resultado<Cliente> create(Long numeroCPF,
                                            String nome,
                                            LocalDate dtNasc,
                                            Endereco endereco,
                                            Telefone telefone) {
        List<Erro> erros = new ArrayList<>();
        CPF cpf = null;

        // Tentar construir o objeto CPF a partir do valor cpf
        if (numeroCPF == null)
            erros.add(Erro.CPF_INVALIDO);
        else {
            cpf = CPF.create(numeroCPF);
            if (cpf == null)
                erros.add(Erro.CPF_INVALIDO);
        }

        // Valida o nome
        if (nome == null || nome.length() < 4)
            erros.add(Erro.NOME_INVALIDO);

        //Valida a data de nascimento
        LocalDate hoje = LocalDate.now();

        if (dtNasc == null || dtNasc.isAfter(hoje))
            erros.add(Erro.DATA_INVALIDA);
        else {
            // Se a dataNasc <= hoje então valida a idade do aluno
            LocalDate limite = LocalDate.of(hoje.getYear() - 18, hoje.getMonth(), hoje.getDayOfMonth());

            if (dtNasc.isAfter(limite))
                erros.add(Erro.CLIENTE_MENOR_DE_IDADE);
        }

        // Verifica se o objeto Endereco existe
        if (endereco == null)
            erros.add(Erro.ENDERECO_INVALIDO);

        // Verifica se o objeto Telefone existe
        if (telefone == null)
            erros.add(Erro.TELEFONE_INVALIDO);

        // Retorna o cliente ou a lista de códigos de erro
        return erros.isEmpty() ?
                Resultado.ok(new Cliente(cpf, nome, dtNasc, endereco, telefone)) :
                Resultado.erro(erros);
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }
}







