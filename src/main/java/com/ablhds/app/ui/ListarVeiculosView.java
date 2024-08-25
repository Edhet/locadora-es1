package com.ablhds.app.ui;

import com.ablhds.app.domain.Veiculo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ListarVeiculosView {
    public String readData() {
        var input = new Scanner(System.in);
        String selecao;

        System.out.println("\n--------------------");
        System.out.println("Listar Veículos");
        System.out.println("--------------------");

        System.out.println("Ordenação Desejada");
        System.out.println("Placa: P");
        System.out.println("Modelo: M");
        selecao = input.nextLine();

        return selecao;
    }
    public void mostrarVeiculos(List<Veiculo> veiculos) {
        //todo formataPlaca() -> formatar placa pra real como no exemplo

        if (veiculos.isEmpty())
            System.out.println("\nNão há veiculos cadastrados");
        else {
            System.out.println("\n-----------------------------------------------------------");
            System.out.println("Placa     Modelo                         Ano  Diária     Km");
            //                  AAA-9999 xxxxxxxx_30_caracteres_xxxxxxx 9999 9999,99 999999
            System.out.println("-----------------------------------------------------------");

            for (var c : veiculos) {
                System.out.printf("%s %-30s %d %f %d\n",
                        c.getPlaca(),
                        c.getModelo(),
                        c.getAno(),
                        c.getDiaria(),
                        c.getQuilometragem());
            }

            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        }
        //todo - tratamento de erros se necessário
    }

    public void mostrarErro() {
        System.out.println("Erro no acesso aos dados. Tente novamente ou procure o suporte!");
    }

}
