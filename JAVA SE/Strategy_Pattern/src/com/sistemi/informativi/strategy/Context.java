package com.sistemi.informativi.strategy;

public class Context {

    private Strategy strategy;

    /**
     * @param strategy
     * parametro passato in input dall'applicazione invocante sottoforma
     * di strategia concreta (MuseumProtocol o CinemaProtocol)
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     *@return
     * numero di protocollo restituito
     * da una delle due Classi che rappresentano le concrete strategie di implementazione,
     * entrambe figlie dell'Interfaccia Strategy
     */
    public String performStrategy() {
        return strategy.getProtocol();
    }
}
