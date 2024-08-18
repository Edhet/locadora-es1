package com.ablhds.app.domain;

public class Placa {
    public final String placa;

    private Placa(String placa) {
        super();
        this.placa = placa;
    }

    public static Placa create(String str) {
        return ehPlacaValida(str) ? new Placa(str) : null;
    }

    private static boolean ehPlacaValida(String str){
        String regexAntigo = "^[A-Z]{3}\\d{4}$";
        String regexNovo = "^[A-Z]{3}\\d{1}[A-Z]{1}\\d{2}$";
        String placaFormatada = str.replace("-", "").replace(" ", "").toUpperCase();
        return placaFormatada.matches(regexAntigo) || placaFormatada.matches(regexNovo);
    }
}
