package com.ablhds.app.ui;

import com.ablhds.app.domain.Locacao;
import java.time.LocalDateTime;
import java.util.regex.Pattern;


import java.time.format.DateTimeFormatter;
import java.util.List;

public class ListarLocacoesView {
    public void mostrarLocacoes(List<Locacao> locacoes) {
        if (locacoes.isEmpty())
            System.out.println("\nNão há locações cadastradas");
        else {
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");

            System.out.println("CPF            Nome                           Placa   Modelo                         Data/hora");
            //                  999.999.999-99 xx_30_caracteres_xx AAA-9999 xx_30_caracteres_xx 99/99/9999 99:99
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");

            for (var l : locacoes) {
                System.out.printf("%s %-30s %s %-30s %s\n",
                        formataCPF(l.getCpfCliente().valor),
                        l.getNomeCliente(),
                        l.getPlacaVeiculo(),//todo - fazer função formataPlaca() || fazer pra funcionalidade ListarVeiculos
                        l.getModeloVeiculo(),
                        formataData(l.getDataHora()));//todo - verificar formatação
            }

            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public void mostrarErro() {
        System.out.println("Erro no acesso aos dados. Tente novamente ou procure o suporte!");
    }//todo - erros (n sei se tem algo pra implementar ou n mas é bom conferir)

    private String formataCPF(Long cpf) {
        return Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})").matcher(cpf.toString()).replaceAll("$1.$2.$3-$4");
    }

    private String formataData(LocalDateTime dt) {
        var df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return df.format(dt);
    }
}
