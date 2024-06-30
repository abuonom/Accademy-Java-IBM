package com.sistemi.informativi.strategy;

public class CinemaProtocol implements Strategy{


    @Override
    public String getProtocol() {
        return "Cinema" + Math.random();
    }
}
