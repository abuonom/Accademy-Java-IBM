package com.sistemi.informativi.strategy;

public class MuseumProtocol implements Strategy{

    @Override
    public String getProtocol() {
        return "Museum" + Math.random();
    }

}
