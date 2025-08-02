package br.ifba.edu.aval.model;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.DNFException;

public class RegraTodosPrismasRegistrados extends RegraApuracao {
    public RegraTodosPrismasRegistrados(RegraApuracao proxima) {
        super(proxima);
    }

    @Override
    protected Duration executarRegra(BoletimProva boletim, Duration tempo) throws DNFException {
        List<Integer> ordemPrismas = boletim.getOrdemPrismas();
        for(int iCont = 0; iCont < ordemPrismas.size() - 1; iCont++) {
            Duration t = boletim.getTempo(ordemPrismas.get(iCont));
            if(ordemPrismas.get(iCont) != Prisma.CHEGADA && t == null)
                throw new DNFException("Atleta não registrou um dos prismas.");
        }
        return tempo;
    }
}
