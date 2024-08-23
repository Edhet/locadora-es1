package com.ablhds.app.ui;

import com.ablhds.app.domain.Erro;

import java.util.List;
import java.util.Scanner;

public class CadastrarVeiculoView {
    public VeiculoData readData() {
        var input = new Scanner(System.in);
        String placa, modelo, ano, diaria, quilometragem;


        System.out.println("\n--------------------");
        System.out.println("Inclusão de Veículos");
        System.out.println("--------------------");

        System.out.print("Placa: ");
        placa = input.nextLine();

        System.out.print("Modelo: ");
        modelo = input.nextLine();

        System.out.print("Ano: ");
        ano = input.nextLine();

        System.out.print("Diaria: ");
        diaria = input.nextLine();

        System.out.print("Quilometragem: ");
        quilometragem = input.nextLine();

        return new VeiculoData(placa, modelo, ano, diaria, quilometragem);
    }


    public void setErros(List<Erro> erros) { //todo - tratamento de erros
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

    public void setSucesso() {
        System.out.println("\nInclusão realizada com sucesso!");
    }

}
