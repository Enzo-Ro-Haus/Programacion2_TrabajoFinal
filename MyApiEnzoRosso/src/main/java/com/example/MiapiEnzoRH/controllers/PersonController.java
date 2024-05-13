package com.example.MiapiEnzoRH.controllers;

import com.example.MiapiEnzoRH.entities.Person;
import com.example.MiapiEnzoRH.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Esto permite ingresar a la API desde distintos clientes, fuentes.
@CrossOrigin(origins = "*")
//Camino para acceder a nuestros recursos de la entidad
@RequestMapping(path = "api/v1/Persons")
public class PersonController {

    //Cada metodo del controlador se corresponde a un servicio.
    PersonaService personaService;

    public PersonController(PersonaService personaService) {
        this.personaService = personaService;
    }
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please try later.\"}");
        }
    }
    @GetMapping("/{id}")//Aca se almacenara l id
    public ResponseEntity<?> getOne(@PathVariable  Long id){ //Esto significa que la id va a estar en la url con la que accedamos
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please try later.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Person entity){//Esto significa que el parametro esta en el body del PostReques.
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.save(entity));
        }catch (Exception e){
            //Aca cambia el error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please try later.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Person entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please try later.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            //Cambia el estado del HTML y usamos NO_CONTENT
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personaService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please try later.\"}");
        }
    }
}

