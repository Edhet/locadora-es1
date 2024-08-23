package com.ablhds.app.ui;

/**
 * DTO usado para transportar os dados da VIEW para o PRESENTER
 */
public record ClienteData(String cpf,
                          String nome,
                          String dtNasc,
                          String logradouro,
                          String numero,
                          String complemento,
                          String bairro,
                          String cidade,
                          String uf,
                          String cep,
                          String ddd,
                          String numeroTel) {}

