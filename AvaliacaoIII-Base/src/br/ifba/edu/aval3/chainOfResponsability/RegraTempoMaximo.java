package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;

import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval3.state.BoletimProva;

/**
 * Verifica se o atleta terminou dentro do tempo máximo permitido.
 */
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
