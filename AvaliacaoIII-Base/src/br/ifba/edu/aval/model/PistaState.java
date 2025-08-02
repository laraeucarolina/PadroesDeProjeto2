package br.ifba.edu.aval.model;

import java.time.Duration;

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
        // já em pista, nada a fazer
    }
}
