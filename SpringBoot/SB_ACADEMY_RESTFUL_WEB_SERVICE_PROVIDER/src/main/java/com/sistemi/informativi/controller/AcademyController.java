package com.sistemi.informativi.controller;


import com.sistemi.informativi.entity.Academy;
import com.sistemi.informativi.service.AcademyService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
L'annotation @RequestMapping consente di identificare l'intero Web Service Provider
con un superpath

In pratica tutte le operazioni esposte dal servizio avranno un prefisso comune di uri:
/rest/api
 */

@RestController
@RequestMapping("/rest/api/academies")
public class AcademyController {
    private AcademyService academyService;

    public AcademyController(AcademyService academyService) {
        this.academyService = academyService;
    }

    //http:/localhost:8080/rest/api/academies
    @GetMapping
    public List<Academy> getAllAcademy() {
        /*
        Qui il Bean Jackson Object Mapper eseguito di default da SpringBoot
        sta in ascolto sul ritorno di ogni singolo metodo del rest controller

        Quindi noi, liberiamo il RestController dalla logica, e richiamiamo il
        metodo gestito in academyService
         */
        return academyService.getAllAcademy();
    }

    @GetMapping("/code/{code}")
    public Academy getAcademyById(@PathVariable String code) {
        return academyService.getAcademyByCode(code);
    }

    /*
    L'annotation @Valid chiede al Jackson Object Mapper di controller all'interno
    del JSON che arriva dal consumer se sono rispettate le regole di validazione
    imposte nel sistema del WSP

    Nel caso in cui venga violata qualche regola di validazione viene restituita
    l'eccezione MethodNotArgumentValidException
     */

    @PostMapping
    public Academy addAcademy(@Valid @RequestBody Academy academy){
        return academyService.saveOrUpdateAcademy(academy);
    }

    @PutMapping
    public Academy updateAcademy(@RequestBody Academy academy){
        return academyService.saveOrUpdateAcademy(academy);
    }

    @DeleteMapping("/code/{code}")
    public Map<String, Boolean> deleteAcademy(@PathVariable String code){
        return academyService.removeAcademy(code);
    }

    @GetMapping("/hateoas/code/{code}")
    public EntityModel<Academy> getAcademyByCodeHateoas(@PathVariable String code){

        Academy academy = academyService.getAcademyByCode(code);
        //Recupero di una academy per code inviato dal consumer
        /*
       1) Occorre inizializzare una variabile di tipo
        EntityModel che consentirà di fare l'attach di uno o più
        link all'intenro del JSON di risposta
         */

        EntityModel<Academy> resource = EntityModel.of(academy);
        //http://localhost:8080/rest/api/academies
        /*
        2) Occorre inizializzare una variabile di tipo WebMvcLinkBuilder che costruisce
        fisicamente un hyperlink all'interno del JSON di risposta
        e fare un riferimento preciso all'interno del link sull'operazione che si
        può consumare in base al click
         */
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllAcademy());

        /*
        E' preferibile associare all'hyperlink una label che faccia capire al
        consumer l'operazione che si consumerà al click del link
         */
        resource.add(linkTo.withRel("all-academies"));
        return resource;
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Academy> getXmlAcademies(){
        return academyService.getAllAcademy();
    }

    /*
    In questo modo, possiamo creare sia un JSON custom, che avere un HTTP Status
    custom
     */
    @PostMapping("/custom/response")
    public ResponseEntity<?> customSaveAcademy(@RequestBody Academy academy) {

        //Viene costruita una hashMap che conterrà i JSON
        academyService.saveOrUpdateAcademy(academy);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("save academy operation", "ok");
        /*
        Viene restituita una ResponseEntity. Ha senso utilizzarlo quando
        si intende restituire un JSON con uno status code associato
        diverso da quello di default specificato nell'architettura REST
         */
        return new ResponseEntity<>(responseMap, HttpStatus.CREATED);

    }
}
