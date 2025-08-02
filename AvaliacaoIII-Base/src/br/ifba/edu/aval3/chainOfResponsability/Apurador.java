package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval3.state.BoletimProva;

/**
 * Configura e executa a cadeia de regras para apurar o resultado
 * de um boletim de prova.
 */
public class Apurador {

    private RegraApuracao regra;

    public Apurador(Duration tempoMaximoProva) {
        this.regra = new RegraTempoBase(
                new RegraTempoMaximo(tempoMaximoProva,
                    new RegraOrdemPrismas(
                        new RegraTodosPrismasRegistrados(
                            new RegraPenalizarAtraso(null)))));
    }

    public Apurador(RegraApuracao regra) {
        this.regra = regra;
    }

    public Duration apurar(BoletimProva boletim) throws DNFException, AtividadeNaoPermitidaException {
        return this.regra.apurar(boletim, Duration.ZERO);
    }
}
