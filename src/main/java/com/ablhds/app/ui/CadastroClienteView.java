package com.ablhds.app.ui;

import com.ablhds.app.domain.Erro;

import java.util.List;
import java.util.Scanner;

/**
 * Classe que cuida da entrada e saída de dados via console
 */
public class CadastroClienteView {

    /**
     * Lê os dados para cadastramento do cliente
     *
     * @return DTO com os dados lidos
     */
    public ClienteData readData() {
        var input = new Scanner(System.in);
        String cpf, nome, dtNasc, logradouro, numero,
                complemento, bairro, cidade, uf, cep, ddd, numeroTel;

        System.out.println("\n--------------------");
        System.out.println("Cadastro de Clientes");
        System.out.println("--------------------");

        System.out.print("CPF: ");
        cpf = input.nextLine();

        System.out.print("Nome: ");
        nome = input.nextLine();

        System.out.print("Data de nascimento (DDMMAAAA): ");
        dtNasc = input.nextLine();

        System.out.print("Logradouro: ");
        logradouro = input.nextLine();

        System.out.print("Número: ");
        numero = input.nextLine();

        System.out.print("Complemento: ");
        complemento = input.nextLine();

        System.out.print("Bairro: ");
        bairro = input.nextLine();

        System.out.print("Cidade: ");
        cidade = input.nextLine();

        System.out.print("UF: ");
        uf = input.nextLine();

        System.out.print("CEP: ");
        cep = input.nextLine();

        System.out.print("DDD: ");
        ddd = input.nextLine();

        System.out.print("Telefone: ");
        numeroTel = input.nextLine();

        // Devolve os dados lidos para o presenter
        return new ClienteData(cpf,
                nome,
                dtNasc,
                logradouro,
                numero,
                complemento,
                bairro,
                cidade,
                uf,
                cep,
                ddd,
                numeroTel);
    }

    /**
     * Imprime as mensagens de erro de acordo com o código
     *
     * @param erros Lista de códigos de erro
     */
    public void setErros(List<Erro> erros) {
        System.out.println("\nErro no cadastramento:");
        for (var erro : erros) {
            switch (erro) {
                case CPF_INVALIDO -> System.out.println("- CPF inválido!");
                case NOME_INVALIDO -> System.out.println("- Nome inválido. Deve ter pelo menos 4 caracteres");
                case DATA_INVALIDA -> System.out.println("- Data inválida!");
                case CLIENTE_MENOR_DE_IDADE -> System.out.println("- Cliente deve ter pelo menos 18 anos");
                case CPF_JA_EXISTENTE -> System.out.println("- Já existe um cliente com esse CPF");
                case LOGRADOURO_INVALIDO -> System.out.println("- Logradouro inválido");
                case NUMERO_INVALIDO -> System.out.println("- Número inválido");
                case COMPLEMENTO_INVALIDO -> System.out.println("- Complemento inválido");
                case BAIRRO_INVALIDO -> System.out.println("- Bairro inválido");
                case CIDADE_INVALIDA -> System.out.println("- Cidade inválida");
                case CEP_INVALIDO -> System.out.println("- CEP inválido. Deve ter 8 dígitos.");
                case UF_INVALIDA -> System.out.println("- UF inválida");
                case DDD_INVALIDO -> System.out.println("- DDD inválido. Deve ter 2 dígitos.");
                case NUMERO_TEL_INVALIDO ->
                        System.out.println("- Número de telefone inválido. Deve ter 8 ou 9 dígitos");
                case ERRO_BD ->
                        System.out.println("- Erro inesperado. Tente novamente mais tarde ou procure o suporte.");
            }
        }
        System.out.println();
    }

    /**
     * Imprime mensagem de sucesso
     */
    public void setSucesso() {
        System.out.println("\nCadastramento realizado com sucesso!");
    }
}
