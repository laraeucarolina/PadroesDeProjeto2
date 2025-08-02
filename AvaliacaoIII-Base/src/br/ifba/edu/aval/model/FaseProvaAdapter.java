package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public abstract class FaseProvaAdapter implements FaseProva {
    protected BoletimProva boletim;
    
    public FaseProvaAdapter(BoletimProva boletim) {
        this.boletim = boletim;
    }

    @Override
    public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar prisma");
    }

    @Override
    public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode calcular minutos de atraso");
    }

    @Override
    public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode calcular minutos de atraso");
    }

    @Override
    public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Fase não permite se apresentar pra largada.");
    }

    @Override
    public void registrarLargada() throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Fase não permite largar.");
    }

    @Override
    public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Fase não permite registro de chegada.");
    }
}
