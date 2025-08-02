package br.ifba.edu.aval3.state;

/**
 * Fase posterior à chegada do atleta.
 */
public class PosProvaState extends FaseProvaAdapter {
    public PosProvaState(BoletimProva boletim) {
        super(boletim);
    }

    @Override
    public void registrarAtrasoPartida(Long minutoPartidaEfetivo) {
        boletim.minutoPartidaEfetivo = minutoPartidaEfetivo;
    }

    @Override
    public Long getMinutosAtraso() {
        return boletim.minutoPartidaEfetivo - boletim.minutoPartidaPrevisto;
    }
}
