package com.example.springmicroservices.controller;

import com.example.springmicroservices.model.InmuebleEntity;
import com.example.springmicroservices.service.IInmuebleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inmueble")
public class InmuebleController {

    private final IInmuebleService inmuebleService;

    public InmuebleController(IInmuebleService inmuebleService) {
        this.inmuebleService = inmuebleService;
    }

    @PostMapping
    public ResponseEntity<?> saveInmueble(@RequestBody InmuebleEntity inmueble){
        return new ResponseEntity<>(inmuebleService.saveInmueble(inmueble), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteInmueble(@PathVariable Long id){
        inmuebleService.deleteInmueble(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllInmuebles(){
        return ResponseEntity.ok(inmuebleService.getAllInmuebles());
    }

}
