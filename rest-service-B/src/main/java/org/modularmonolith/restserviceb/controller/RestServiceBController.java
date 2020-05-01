/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modularmonolith.restserviceb.controller;

import org.modularmonolith.restserviceb.model.HelloMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nemanja
 */
@RestController
public class RestServiceBController {
    
    @GetMapping("/hello/b")
    public ResponseEntity hello(@RequestParam(required = false) String name) {
        String message = name == null ? "B: Hello!" : "B: Hello " + name + "!";
        return new ResponseEntity(new HelloMessage(message), HttpStatus.OK);
    }
    
}
