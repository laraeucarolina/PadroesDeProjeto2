package br.ifba.edu.aval3.state;

import java.time.Duration;

import br.ifba.edu.aval.model.Prisma;

/**
 * Fase de prova em que o atleta está na pista.
 */
public class PistaState extends FaseProvaAdapter {
    public PistaState(BoletimProva boletim) {
        super(boletim);
    }

    @Override
    public void registrar(Integer prismaID, Duration tempo) {
        boletim.passagens.registrarPassagem(prismaID, tempo);
    }

    @Override
    public void registrarAtrasoPartida(Long minutoPartidaEfetivo) {
        boletim.minutoPartidaEfetivo = minutoPartidaEfetivo;
    }

    @Override
    public Long getMinutosAtraso() {
        return boletim.minutoPartidaEfetivo - boletim.minutoPartidaPrevisto;
    }

    @Override
    public void registrarChegada(Duration tempo) {
        boletim.passagens.registrarPassagem(Prisma.CHEGADA, tempo);
        boletim.setFase(new PosProvaState(boletim));
    }

    @Override
    public void registrarLargada() {
        // já em pista
    }
}
