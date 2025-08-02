package br.ifba.edu.aval.model;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public class MomentoLargadaState extends FaseProvaAdapter {
    public MomentoLargadaState(BoletimProva boletim) {
        super(boletim);
    }

    @Override
    public void registrarAtrasoPartida(Long minutoPartidaEfetivo) {
        boletim.minutoPartidaEfetivo = minutoPartidaEfetivo;
    }

    @Override
    public Long getMinutosAtraso() {
        return boletim.minutoPartidaEfetivo - boletim.minutoPartidaPrevisto;
    }

    @Override
    public void apresentarPraLargada() {
        // já apresentado, nada a fazer
    }

    @Override
    public void registrarLargada() {
        boletim.setFase(new PistaState(boletim));
    }
}
