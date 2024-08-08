package com.ablhds.app.domain;

import java.util.List;

/**
 * Classe que armazena ou um valor (do tipo generico T) ou uma lista de erros
 * Não pode armazenar os dois ao mesmo tempo: ou um ou outro (mutuamente exclusivo)
 * Usada na criação dos objetos do domínio
 *
 * @param <T> Tipo do objeto a ser armazenado
 */
public class Resultado<T> {

    public final T valor;
    public final List<Erro> erros;

    /**
     * Verifica se o resultado guarda um resultado bem sucedido
     *
     * @return True, se for bem sucedido ou false, caso contrário
     */
    public boolean sucesso() {
        return valor != null;
    }

    /**
     * Verifica se o resultado guarda um resultado mal sucedido
     *
     * @return True, se for mal sucedido ou false, caso contrário
     */
    public boolean falha() {
        return erros != null;
    }

    private Resultado(T resultado) {
        this.valor = resultado;
        this.erros = null;
    }

    private Resultado(List<Erro> erro) {
        this.valor = null;
        this.erros = erro;
    }

    /**
     * Cria um resultado bem sucedido
     *
     * @param <T>   Tipo do objeto a ser armazenado
     * @param valor Objeto a ser armazenado
     * @return Resultado com o objeto armazenado nele
     */
    public static <T> Resultado<T> ok(T valor) {
        return new Resultado<T>(valor);
    }

    /**
     * Cria um resultado mal sucedido
     *
     * @param <T>  Tipo do objeto a ser armazenado
     * @param erro Lista de códigos de erro
     * @return Resultado com a lista de códigos de erro armazenado nele
     */
    public static <T> Resultado<T> erro(List<Erro> erro) {
        return new Resultado<T>(erro);
    }
}
