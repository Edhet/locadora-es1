package com.ablhds.app.domain;

/**
 * Unidades da federação
 */
public enum UF {
    RS,
    SC,
    PR,
    MS,
    MT,
    GO,
    DF,
    SP,
    RJ,
    ES,
    MG,
    BA,
    SE,
    AL,
    PB,
    PE,
    CE,
    RN,
    PI,
    MA,
    TO,
    AM,
    PA,
    RO,
    RR,
    AP,
    AC;

    /**
     * Verifica se uma string corresponde a alguma unidade da federação
     *
     * @param uf Sigla da UF
     * @return UF ou null, caso a sigla seja inválida
     */
    public static UF getUF(String uf) {
        for (var e : UF.values())
            if (e.name().equals(uf)) {
                return e;
            }

        return null;
    }
}
