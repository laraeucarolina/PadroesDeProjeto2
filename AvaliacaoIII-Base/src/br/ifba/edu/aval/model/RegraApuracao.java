package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;

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

    protected abstract Duration executarRegra(BoletimProva boletim, Duration tempo) throws DNFException, AtividadeNaoPermitidaException;
}
