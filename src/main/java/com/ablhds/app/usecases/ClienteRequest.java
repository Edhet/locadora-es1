package com.ablhds.app.usecases;

import java.time.LocalDate;

/**
 * DTO usado para transportar os dados do PRESENTER para o CONTROLLER
 */
public record ClienteRequest(Long cpf,
                             String nome,
                             LocalDate dtNasc,
                             String logradouro,
                             String numero,
                             String complemento,
                             String bairro,
                             String cidade,
                             String uf,
                             Long cep,
                             Integer ddd,
                             Long numeroTel) {

}
