package com.ablhds.app.ui;


import com.ablhds.app.domain.Erro;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class LocarVeiculoView {
    public LocacaoData readData() {
        var input = new Scanner(System.in);
        String cpf, placa;

        System.out.println("\n--------------------");
        System.out.println("Locação de Veículos");
        System.out.println("--------------------");

        System.out.print("CPF: ");
        cpf = input.nextLine();

        System.out.print("Placa: ");
        placa = input.nextLine();


        return new LocacaoData(cpf, placa, LocalDateTime.now());
    }

    public void setErros(List<Erro> erros) {
        System.out.println("\nErro na locação:");
        for (var erro : erros) {
            switch (erro) {
                case CLIENTE_INEXISTENTE -> System.out.println("- CPF inválido!");
                case VEICULO_JA_ALOCADO -> System.out.println("- Veículo já alocado!");
                case LOCACAO_INVALIDA -> System.out.println("- Locação inválida!"); //todo - mudar descrição desse case
                case VEICULO_INEXISTENTE -> System.out.println("- Placa inválida!");
                case ERRO_BD ->
                        System.out.println("- Erro inesperado. Tente novamente mais tarde ou procure o suporte.");
            }
        }
        System.out.println();
    }

    public void setSucesso() {
        System.out.println("\nLocação bem-sucedida");
    }

}
