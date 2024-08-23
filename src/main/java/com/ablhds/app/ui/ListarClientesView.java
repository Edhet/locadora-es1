package com.ablhds.app.ui;

import com.ablhds.app.domain.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ListarClientesView {
    public String readData() {
        var input = new Scanner(System.in);
        String selecao;

        System.out.println("\n--------------------");
        System.out.println("Listar Clientes");
        System.out.println("--------------------");

        System.out.print("Ordenação Desejada");
        System.out.print("CPF: C");
        System.out.print("Nome: N");
        selecao = input.nextLine();

        return selecao;
    }

        public void mostrarClientes(List<Cliente> clientes) {

        if (clientes.isEmpty())
            System.out.println("\nNão há clientes cadastrados");
        else {
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("CPF            Nome                           Dt.Nasc.   Endereço                                           Telefone");
            //                  999.999.999-99 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx 99/99/9999 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx (99) 999999999
            //                                                                           xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            //                                                                           xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");

            for (var c : clientes) {
                System.out.printf("%s %-30s %s %-50s (%d) %d\n",
                        formataCPF(c.getCpf().valor),
                        c.getNome(),
                        formataData(c.getDtNasc()),
                        c.getEndereco().getLogradouro() + ',' + c.getEndereco().getNumero() + ',' + c.getEndereco().getComplemento(),
                        c.getTelefone().getDdd(),
                        c.getTelefone().getNumero());
                System.out.printf("%56c %s\n", ' ',
                        c.getEndereco().getBairro() + '-' + c.getEndereco().getCidade() + '-' + c.getEndereco().getUf().name());
                System.out.printf("%56c CEP: %d\n", ' ',
                        c.getEndereco().getCep());
            }

            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public void mostrarErro() {
        System.out.println("Erro no acesso aos dados. Tente novamente ou procure o suporte!");
    }

    private String formataCPF(Long cpf) {
        return Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})").matcher(cpf.toString()).replaceAll("$1.$2.$3-$4");
    }

    private String formataData(LocalDate dt) {
        var df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return df.format(dt);
    }
}
