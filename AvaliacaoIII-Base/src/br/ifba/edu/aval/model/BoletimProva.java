package br.ifba.edu.aval.model;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval1.prototype.ListaPassagens;

public class BoletimProva {

    public String cboNumero;
    public ListaPassagens passagens;
    public Long minutoPartidaPrevisto;
    public Long minutoPartidaEfetivo;

    private FaseProva fase;

    public BoletimProva(String cboNumero, Long minutoPartidaPrevisto, ListaPassagens passagens) {
        super();
        this.cboNumero = cboNumero;
        this.passagens = passagens;
        this.minutoPartidaEfetivo = this.minutoPartidaPrevisto = minutoPartidaPrevisto;
        this.fase = new PreProvaState(this);
    }

    void setFase(FaseProva fase) {
        this.fase = fase;
    }

    public List<Integer> getOrdemPrismas() {
        return this.passagens.getOrdemPassagem();
    }

    public String cboNumero() {
        return this.cboNumero;
    }

    @Override
    public String toString() {
        return "BoletimProva [cboNumero=" + cboNumero + ", passagens=" + passagens + "]";
    }

    public Duration getTempo(Integer prismaID) {
        return this.passagens.getTempo(prismaID);
    }

    public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
        this.fase.registrar(prismaID, tempo);
    }

    public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
        this.fase.registrarAtrasoPartida(minutoPartidaEfetivo);
    }

    public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
        return this.fase.getMinutosAtraso();
    }

    public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
        this.fase.apresentarPraLargada();
    }

    public void registrarLargada() throws AtividadeNaoPermitidaException {
        this.fase.registrarLargada();
    }

    public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
        this.fase.registrarChegada(tempo);
    }
}
