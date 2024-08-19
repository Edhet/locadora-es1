package com.ablhds.app.usecases;

import com.ablhds.app.domain.VeiculoRepository;

public class LocarVeiculosCtrl {
    private final VeiculoRepository repo;

    public LocarVeiculosCtrl(VeiculoRepository repo) {
        super();
        this.repo = repo;
    }


}
