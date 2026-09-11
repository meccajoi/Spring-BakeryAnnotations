package com.zipcodewilmington.bakery.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;

@Controller
public class BakerController {

    private BakerService service;

    public BakerController(BakerService service) {
        this.service = service;
    }
    @RequestMapping(value = "/bakers/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Baker>> index() {
    return new ResponseEntity<>(service.index(), HttpStatus.OK);
   
    }

    @RequestMapping(value = "/bakers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Baker> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/bakers/", method = RequestMethod.POST)
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(
                service.create(baker),
                HttpStatus.CREATED
        );
    }
    @RequestMapping(value = "/bakers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Baker> update(
        @PathVariable("id") Long id,
        @RequestBody Baker baker) {

        return new ResponseEntity<>(
            service.update(id, baker),
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/bakers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> destroy(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
            service.delete(id),
            HttpStatus.OK
        );
    }
}