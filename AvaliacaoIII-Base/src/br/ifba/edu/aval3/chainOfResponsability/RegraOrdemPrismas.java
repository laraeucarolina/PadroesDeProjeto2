package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval3.state.BoletimProva;

/**
 * Confere se os prismas foram registrados na ordem prevista.
 */
public class RegraOrdemPrismas extends RegraApuracao {
    public RegraOrdemPrismas(RegraApuracao proxima) {
        super(proxima);
    }

    @Override
    protected Duration executarRegra(BoletimProva boletim, Duration tempo) throws DNFException {
        List<Integer> ordemPrismas = boletim.getOrdemPrismas();
        for(int iCont = 0; iCont < ordemPrismas.size() - 1; iCont++) {
            Duration anterior = boletim.getTempo(ordemPrismas.get(iCont));
            Duration atual = boletim.getTempo(ordemPrismas.get(iCont+1));
            if(anterior != null && atual != null)
                if(anterior.compareTo(atual) > 0)
                    throw new DNFException("Atleta registrou prisma fora da ordem");
        }
        return tempo;
    }
}
