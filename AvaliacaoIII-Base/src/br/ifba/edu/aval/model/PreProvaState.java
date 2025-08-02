package br.ifba.edu.aval.model;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public class PreProvaState extends FaseProvaAdapter {
    public PreProvaState(BoletimProva boletim) {
        super(boletim);
    }

    @Override
    public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
        boletim.setFase(new MomentoLargadaState(boletim));
    }
}
