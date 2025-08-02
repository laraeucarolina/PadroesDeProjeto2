package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public interface FaseProva {
    void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException;
    void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException;
    Long getMinutosAtraso() throws AtividadeNaoPermitidaException;
    void apresentarPraLargada() throws AtividadeNaoPermitidaException;
    void registrarLargada() throws AtividadeNaoPermitidaException;
    void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException;
}
