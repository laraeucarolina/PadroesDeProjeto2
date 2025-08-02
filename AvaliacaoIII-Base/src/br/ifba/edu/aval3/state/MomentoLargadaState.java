package br.ifba.edu.aval3.state;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

/**
 * Fase na qual o atleta já se apresentou, mas ainda não largou.
 */
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
        // já apresentado
    }

    @Override
    public void registrarLargada() {
        boletim.setFase(new PistaState(boletim));
    }
}
