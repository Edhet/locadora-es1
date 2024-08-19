package com.ablhds.app.ui;

import com.ablhds.app.domain.Veiculo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

public class ListarVeiculosView {
    public void mostrarVeiculos(List<Veiculo> veiculos) {
        //todo Ler do usuário a ordenação desejada: P-Placa ou M-Modelo.
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
    }

    public void mostrarErro() {
        System.out.println("Erro no acesso aos dados. Tente novamente ou procure o suporte!");
    }

    /*private String formataCPF(Long cpf) {
        return Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})").matcher(cpf.toString()).replaceAll("$1.$2.$3-$4");
    }

    private String formataData(LocalDate dt) {
        var df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return df.format(dt);
    }*/

}
