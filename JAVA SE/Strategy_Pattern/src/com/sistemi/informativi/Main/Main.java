package com.sistemi.informativi.Main;

import com.sistemi.informativi.strategy.Context;
import com.sistemi.informativi.strategy.MuseumProtocol;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new MuseumProtocol());
        System.out.println(context.performStrategy());
    }
}
