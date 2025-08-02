package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.exception.DNFException;

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
