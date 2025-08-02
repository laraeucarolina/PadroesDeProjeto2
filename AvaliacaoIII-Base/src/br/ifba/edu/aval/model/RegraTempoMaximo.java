package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.exception.DNFException;

public class RegraTempoMaximo extends RegraApuracao {
    private Duration tempoMaximo;

    public RegraTempoMaximo(Duration tempoMaximo, RegraApuracao proxima) {
        super(proxima);
        this.tempoMaximo = tempoMaximo;
    }

    @Override
    protected Duration executarRegra(BoletimProva boletim, Duration tempo) throws DNFException {
        if(tempo.compareTo(this.tempoMaximo) > 0)
            throw new DNFException("O atleta finalizou a prova, após o tempo limite");
        return tempo;
    }
}
