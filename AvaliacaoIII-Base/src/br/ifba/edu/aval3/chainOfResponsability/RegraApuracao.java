package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval3.state.BoletimProva;

/**
 * Handler abstrato da cadeia de regras de apuração.
 */
public abstract class RegraApuracao {
    protected RegraApuracao proxima;

    public RegraApuracao(RegraApuracao proxima) {
        this.proxima = proxima;
    }

    public Duration apurar(BoletimProva boletim, Duration tempo) throws DNFException, AtividadeNaoPermitidaException {
        Duration novoTempo = this.executarRegra(boletim, tempo);
        if(this.proxima != null)
            return this.proxima.apurar(boletim, novoTempo);
        return novoTempo;
    }

    protected abstract Duration executarRegra(BoletimProva boletim, Duration tempo)
            throws DNFException, AtividadeNaoPermitidaException;
}
