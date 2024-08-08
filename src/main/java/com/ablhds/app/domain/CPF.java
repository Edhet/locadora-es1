package com.ablhds.app.domain;

/**
 * Value Object que trata o CPF
 */
public class CPF {

    public final Long valor;

    /**
     * Construtor privado obriga a criar o objeto com o método 'create'
     *
     * @param valor Número do CPF
     */
    private CPF(Long valor) {
        super();
        this.valor = valor;
    }

    /**
     * Valida e cria o CPF
     *
     * @param numero Número do CPF
     * @return CPF ou null, se número não é um CPF
     */
    public static CPF create(Long numero) {
        // Verificar se numero é um cpf válido
        // Se for retorna o objeto CPF
        // senão retorna null
        return ehCPFValido(numero) ? new CPF(numero) : null;
    }

    /**
     * Verifica se um número é um CPF
     *
     * @param valor Número do CPF
     * @return True, se for válido ou false, caso contrário
     */
    private static boolean ehCPFValido(long valor) {
        int primeiroDV, segundoDV, soma, resto, j, k;
        long numeroCPF;
        int mult[] = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        // Se cpf não está no intervalo válido ou se tem todos os dígitos iguais
        // então é inválido
        if (valor < 10000000000L || valor > 99999999999L || valor % 11111111111L == 0)
            return false;

        // Pega o primeiro e o segundo DV do cpf
        primeiroDV = (int) (valor % 100 / 10);
        segundoDV = (int) (valor % 10);

        // Calcula primeiro DV
        numeroCPF = valor / 100; // Número do cpf sem os DVs
        soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (numeroCPF % 10) * mult[i];
            numeroCPF /= 10;
        }

        resto = soma % 11;

        if (resto == 0 || resto == 1)
            j = 0;
        else
            j = 11 - resto;

        // Compara o primeiro DV calculado com o informado
        // Se é inválido, então nem precisa calcular o segundo DV
        if (j != primeiroDV)
            return false;

        // Calcula segundo DV
        numeroCPF = valor / 10;  // Número do cpf sem segundo DV
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (numeroCPF % 10) * mult[i];
            numeroCPF /= 10;
        }

        resto = soma % 11;

        if (resto == 0 || resto == 1)
            k = 0;
        else
            k = 11 - resto;

        // Compara o segundo DV calculado com o informado
        return k == segundoDV;
    }

}
