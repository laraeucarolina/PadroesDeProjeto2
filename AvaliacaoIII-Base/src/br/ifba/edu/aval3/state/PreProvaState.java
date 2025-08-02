package br.ifba.edu.aval3.state;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

/**
 * Fase anterior à largada. O atleta ainda não se apresentou.
 */
public class PreProvaState extends FaseProvaAdapter {
    public PreProvaState(BoletimProva boletim) {
        super(boletim);
    }

    @Override
    public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
        boletim.setFase(new MomentoLargadaState(boletim));
    }
}
