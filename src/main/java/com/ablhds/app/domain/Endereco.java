package com.ablhds.app.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um endereço
 */
public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private UF uf;
    private Long cep;

    /**
     * Construtor privado que obriga a criar o objeto com o método 'create'
     *
     * @param logradouro  Logradouro
     * @param numero      Número
     * @param complemento Complemento
     * @param bairro      Bairro
     * @param cidade      Cidade
     * @param strUF       UF
     * @param cep         CEP
     */
    private Endereco(String logradouro,
                     String numero,
                     String complemento,
                     String bairro,
                     String cidade,
                     UF uf,
                     Long cep) {
        super();
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    /**
     * Valida os dados e cria o Endereço
     *
     * @param logradouro  Logradouro
     * @param numero      Número
     * @param complemento Complemento
     * @param bairro      Bairro
     * @param cidade      Cidade
     * @param strUF       UF
     * @param cep         CEP
     * @return Endereço ou lista de códigos de erro
     */
    public static Resultado<Endereco> create(String logradouro, String numero,
                                             String complemento, String bairro,
                                             String cidade,
                                             String strUF, Long cep) {
        List<Erro> erros = new ArrayList<>();
        UF uf = null;

        if (logradouro == null || logradouro.isBlank())
            erros.add(Erro.LOGRADOURO_INVALIDO);

        if (numero == null || numero.isBlank())
            erros.add(Erro.NUMERO_INVALIDO);

        if (complemento == null)
            erros.add(Erro.COMPLEMENTO_INVALIDO);

        if (bairro == null || bairro.isBlank())
            erros.add(Erro.BAIRRO_INVALIDO);

        if (cidade == null || cidade.isBlank())
            erros.add(Erro.CIDADE_INVALIDA);

        if (strUF == null)
            erros.add(Erro.UF_INVALIDA);
        else {
            uf = UF.getUF(strUF.toUpperCase());

            if (uf == null)
                erros.add(Erro.UF_INVALIDA);
        }

        if (cep == null || cep < 1000000 || cep > 99999999)
            erros.add(Erro.CEP_INVALIDO);

        // Retorna o endereço ou a lista de códigos de erro
        return erros.isEmpty() ?
                Resultado.ok(new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep)) :
                Resultado.erro(erros);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public UF getUf() {
        return uf;
    }

    public Long getCep() {
        return cep;
    }
}
