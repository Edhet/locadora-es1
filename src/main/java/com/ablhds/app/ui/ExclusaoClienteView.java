package com.ablhds.app.ui;

import com.ablhds.app.domain.Erro;

import java.util.List;
import java.util.Scanner;

public class ExclusaoClienteView {
    public ClienteCPFData readData() {
        var input = new Scanner(System.in);
        String cpf;

        System.out.println("\n--------------------");
        System.out.println("Exclusão de Clientes");
        System.out.println("--------------------");

        System.out.print("CPF: ");
        cpf = input.nextLine();

        // Devolve os dados lidos para o presenter
        return new ClienteCPFData(cpf);
    }

    public void setErros(List<Erro> erros) {
        System.out.println("\nErro na exclusão:");
        for (var erro : erros) {
            switch (erro) {
                case CLIENTE_INEXISTENTE -> System.out.println("- Cliente não encontrado!");
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
        System.out.println("\nExclusão bem-sucedida");
    }

}
