package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;

import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval3.state.BoletimProva;

/**
 * Primeiro passo da cadeia: obtém o tempo base da prova.
 */
public class RegraTempoBase extends RegraApuracao {
    public RegraTempoBase(RegraApuracao proxima) {
        super(proxima);
    }

    @Override
    protected Duration executarRegra(BoletimProva boletim, Duration tempo) throws DNFException {
        Duration tempoProva = boletim.getTempo(Prisma.CHEGADA);
        if(tempoProva == null)
            throw new DNFException("Atleta não registrou chegada");
        return tempoProva;
    }
}
