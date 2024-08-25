package com.ablhds.app.domain;

import java.util.regex.Pattern;

public class Placa {
    public final String placa;

    private Placa(String placa) {
        super();
        this.placa = placa;
    }

    public static Placa create(String str) {
        return placaTemFormatoValido(str) ? new Placa(str) : null;
    }

    private static boolean placaTemFormatoValido(String str){
        Pattern formatoPlaca = Pattern.compile("[]A-Za-z]{3}\\d{4}");
        return formatoPlaca.matcher(str).matches();
    }

    @Override
    public String toString() {
        return placa;
    }
}
