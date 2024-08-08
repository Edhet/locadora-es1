package com.ablhds.app.ui;

import com.ablhds.app.domain.Erro;
import com.ablhds.app.usecases.CadastroClienteCtrl;
import com.ablhds.app.usecases.ClienteRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Classe que controla a entrada de dados e dispara a funcionalidade de cadastro dos clientes
 */
public class CadastroClientePrt implements Presenter {

    private CadastroClienteView view;
    private CadastroClienteCtrl controller;

    public CadastroClientePrt(CadastroClienteView view, CadastroClienteCtrl controller) {
        super();
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void run() {
        Long cpf, cep, numeroTel;
        Integer ddd;
        LocalDate dtNasc;
        List<Erro> erros;

        do {
            // 1 - Lê os dados da view

            var data = view.readData();

            // 2 - Converte os dados

            try {
                cpf = Long.parseLong(data.cpf());
            } catch (Exception ex) {
                cpf = null;
            }

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                dtNasc = LocalDate.parse(data.dtNasc(), formatter);
            } catch (Exception ex) {
                dtNasc = null;
            }

            try {
                cep = Long.parseLong(data.cep());
            } catch (Exception ex) {
                cep = null;
            }

            try {
                ddd = Integer.parseInt(data.ddd());
            } catch (Exception ex) {
                ddd = null;
            }

            try {
                numeroTel = Long.parseLong(data.numeroTel());
            } catch (Exception ex) {
                numeroTel = null;
            }

            // 3 - Entrega os dados para o controller para processar o cadastro

            erros = controller.cadastrarCliente(new ClienteRequest(cpf,
                    data.nome(),
                    dtNasc,
                    data.logradouro(),
                    data.numero(),
                    data.complemento(),
                    data.bairro(),
                    data.cidade(),
                    data.uf(),
                    cep,
                    ddd,
                    numeroTel));

            // 4 - Verificar o status do processamento

            if (erros != null)
                view.setErros(erros);
            else
                view.setSucesso();
        } while (erros != null);
    }
}
