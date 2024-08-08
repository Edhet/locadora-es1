package com.ablhds.app.domain.dao;

import java.time.LocalDate;

/**
 * Classe usada para transportar dados do ClienteDAO para o ClienteRepository
 */
public record ClienteDTO(String id,
                         Long cpf,
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
