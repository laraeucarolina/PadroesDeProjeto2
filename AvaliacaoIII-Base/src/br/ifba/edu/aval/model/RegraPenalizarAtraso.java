package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public class RegraPenalizarAtraso extends RegraApuracao {
    public RegraPenalizarAtraso(RegraApuracao proxima) {
        super(proxima);
    }

    @Override
    protected Duration executarRegra(BoletimProva boletim, Duration tempo) throws AtividadeNaoPermitidaException {
        return tempo.plus(Duration.ofMinutes(boletim.getMinutosAtraso()));
    }
}
