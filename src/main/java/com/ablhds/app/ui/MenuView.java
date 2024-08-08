package com.ablhds.app.ui;

import java.util.Scanner;

/**
 * Classe responsável por apresentar os menus da aplicação
 */
public class MenuView {

    public enum Opcao {
        CADASTRAR_CLIENTE,
        EXCLUIR_CLIENTE,
        LISTAR_CLIENTE,
        CADASTRAR_VEICULO,
        EXCLUIR_VEICULO,
        LISTAR_VEICULO,
        LOCAR_VEICULO,
        DEVOLVER_VEICULO,
        LISTAR_LOCACAO,
        FIM
    }

    ;

    private enum TipoMenu {
        PRINCIPAL,
        CLIENTE,
        VEICULO,
        LOCACAO
    }

    ;

    private TipoMenu menu = TipoMenu.PRINCIPAL;

    /**
     * Retorna a opção do menu selecionada pelo usuário
     *
     * @return Opção do menu
     */
    public Opcao getOpcao() {
        int opcao = 0;

        for (; ; ) {
            opcao = switch (menu) {
                case PRINCIPAL -> showPrincipal();
                case CLIENTE -> showClientes();
                case VEICULO -> showVeiculos();
                case LOCACAO -> showLocacao();
            };

            switch (opcao) {
                case 1:
                    menu = TipoMenu.CLIENTE;
                    break;
                case 2:
                    menu = TipoMenu.VEICULO;
                    break;
                case 3:
                    menu = TipoMenu.LOCACAO;
                    break;
                case 4:
                    return Opcao.FIM;
                case 11:
                    return Opcao.CADASTRAR_CLIENTE;
                case 12:
                    return Opcao.EXCLUIR_CLIENTE;
                case 13:
                    return Opcao.LISTAR_CLIENTE;
                case 21:
                    return Opcao.CADASTRAR_VEICULO;
                case 22:
                    return Opcao.EXCLUIR_VEICULO;
                case 23:
                    return Opcao.LISTAR_VEICULO;
                case 31:
                    return Opcao.LOCAR_VEICULO;
                case 32:
                    return Opcao.DEVOLVER_VEICULO;
                case 33:
                    return Opcao.LISTAR_LOCACAO;
                case 14:
                case 24:
                case 34:
                    menu = TipoMenu.PRINCIPAL;
                    break;
            }
        }
    }

    /**
     * Apresenta o menu principal e lê a opção do usuário
     *
     * @return Opção do usuário
     */
    public int showPrincipal() {
        System.out.println("\n--------------");
        System.out.println("Menu Principal");
        System.out.println("--------------");
        System.out.println("1-Clientes");
        System.out.println("2-Veiculos");
        System.out.println("3-Locação");
        System.out.println("4-Fim");
        System.out.print("Opção: ");

        return lerOpcao(1, 4);
    }

    /**
     * Apresenta o menu de clientes e lê a opção do usuário
     *
     * @return Opção do menu
     */
    private int showClientes() {
        System.out.println("\n-------------------");
        System.out.println("Menu de Clientes");
        System.out.println("-------------------");
        System.out.println("1-Cadastrar cliente");
        System.out.println("2-Excluir cliente");
        System.out.println("3-Listar clientes");
        System.out.println("4-Voltar");
        System.out.print("Opção: ");

        return 10 + lerOpcao(1, 4);
    }

    /**
     * Apresenta o menu de veículos e lê a opção do usuário
     *
     * @return Opção do menu
     */
    private int showVeiculos() {
        System.out.println("\n-------------------");
        System.out.println("Menu de Veículos");
        System.out.println("-------------------");
        System.out.println("1-Cadastrar veículo");
        System.out.println("2-Excluir veículo");
        System.out.println("3-Listar veículos");
        System.out.println("4-Voltar");
        System.out.print("Opção: ");

        return 20 + lerOpcao(1, 4);
    }

    /**
     * Apresenta o menu de locação e lê a opção do usuário
     *
     * @return Opção do menu
     */
    private int showLocacao() {
        System.out.println("\n------------------");
        System.out.println("Menu de Locação");
        System.out.println("------------------");
        System.out.println("1-Locar veículo");
        System.out.println("2-Devolver veículo");
        System.out.println("3-Listar locações");
        System.out.println("4-Voltar");
        System.out.print("Opção: ");

        return 30 + lerOpcao(1, 4);
    }

    /**
     * Lè um valor inteiro no intervalo (min, max)
     *
     * @param min Valor mínimo
     * @param max Valor máximo
     * @return Valor lido
     */
    private int lerOpcao(int min, int max) {
        var input = new Scanner(System.in);
        int opcao = 0;

        do {
            try {
                opcao = input.nextInt();

                if (opcao < min || opcao > max)
                    System.out.println("Opção inválida!");
            } catch (Exception ex) {
                System.out.println("Opção inválida!");
                continue;
            }
        } while (opcao < min || opcao > max);

        return opcao;
    }
}
