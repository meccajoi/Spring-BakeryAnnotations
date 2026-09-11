package com.zipcodewilmington.bakery.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;

@Controller
public class MuffinController {

    private MuffinService service;

    public MuffinController(MuffinService service) {
        this.service = service;
    }

    @RequestMapping(value = "/muffins/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @RequestMapping(value = "/muffins/{id}", method = RequestMethod.GET)
    public ResponseEntity<Muffin> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/muffins/", method = RequestMethod.POST)
    public ResponseEntity<Muffin> create(@RequestBody Muffin muffin) {
        return new ResponseEntity<>(
                service.create(muffin),
                HttpStatus.CREATED
        );
    }

    @RequestMapping(value = "/muffins/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Muffin> update(
            @PathVariable("id") Long id,
            @RequestBody Muffin muffin) {

        return new ResponseEntity<>(
                service.update(id, muffin),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/muffins/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> destroy(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                service.delete(id),
                HttpStatus.OK
        );
    }
}