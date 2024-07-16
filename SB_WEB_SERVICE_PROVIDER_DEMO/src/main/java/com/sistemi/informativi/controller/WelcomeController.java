package com.sistemi.informativi.controller;

import com.sistemi.informativi.bean.MessageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    /*
    Esposizione di una operazione rest composta dalla coppia:

    GET (VERBO HTTP) + URL "welcome"
    Tutte le applicazioni Consumer che intendano consumare questa
    operazione dovranno eseguire la richiesta http:

    http://localhost:8080/x

    Quando creo un controller, sto in realtà generando un API Rest

     */

    @GetMapping("/welcome")
    public MessageBean welcome() {
        MessageBean messageBean;
        return messageBean = new MessageBean("WELCOME");
    }
}
