package com.ablhds.app.ui;

import com.ablhds.app.domain.Erro;
import com.ablhds.app.domain.Veiculo;

import java.util.List;
import java.util.Scanner;

public class ExclusaoVeiculoView {
    public PlacaVeiculoData readData() {
        var input = new Scanner(System.in);
        String placa;

        System.out.println("\n--------------------");
        System.out.println("Exclusão de Veículos");
        System.out.println("--------------------");

        System.out.print("Placa: ");
        placa = input.nextLine();

        // Devolve os dados lidos para o presenter
        return new PlacaVeiculoData(placa);
    }

    public void setErros(List<Erro> erros) {
        System.out.println("\nErro na exclusão:");
        for (var erro : erros) {
            switch (erro) { // todo - erros de exclusão de veículos
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
