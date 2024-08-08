package com.ablhds.app.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um telefone
 */
public class Telefone {
    private Integer ddd;
    private Long numero;

    /**
     * Construtor privado que obriga a criar o objeto com o método 'create'
     *
     * @param ddd    DDD
     * @param numero Número do telefone
     */
    private Telefone(Integer ddd, Long numero) {
        super();
        this.ddd = ddd;
        this.numero = numero;
    }

    /**
     * Valida os dados e cria o telefone
     *
     * @param ddd    DDD
     * @param numero Número do telefone
     * @return Telefone ou lista de códigos de erro
     */
    public static Resultado<Telefone> create(Integer ddd, Long numero) {
        List<Erro> erros = new ArrayList<>();

        // Valida o DDD
        if (ddd == null || ddd < 11 || ddd > 99)
            erros.add(Erro.DDD_INVALIDO);

        // Valida o número de telefone
        if (numero == null || numero < 20000000 || numero > 999999999)
            erros.add(Erro.NUMERO_TEL_INVALIDO);

        // Retorna o telefone ou a lista de códigos de erro
        return erros.isEmpty() ?
                Resultado.ok(new Telefone(ddd, numero)) :
                Resultado.erro(erros);
    }

    public Integer getDdd() {
        return ddd;
    }

    public Long getNumero() {
        return numero;
    }
}
