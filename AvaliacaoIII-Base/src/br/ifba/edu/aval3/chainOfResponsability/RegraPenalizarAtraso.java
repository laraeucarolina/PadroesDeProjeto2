package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval3.state.BoletimProva;

/**
 * Adiciona penalização por atraso à largada.
 */
public class RegraPenalizarAtraso extends RegraApuracao {
    public RegraPenalizarAtraso(RegraApuracao proxima) {
        super(proxima);
    }

    @Override
    protected Duration executarRegra(BoletimProva boletim, Duration tempo) throws AtividadeNaoPermitidaException {
        return tempo.plus(Duration.ofMinutes(boletim.getMinutosAtraso()));
    }
}
