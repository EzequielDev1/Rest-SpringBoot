package br.erudio.controllers;

import br.erudio.model.Estudante;
import br.erudio.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/estudante")
public class EstudanteController {

    @Autowired
    EstudanteService service;

    @GetMapping
    public List<Estudante> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
 public Estudante buscarPorID(@PathVariable UUID id){
       return service.buscarId(id);
    }

    @PostMapping("/criar")
    public Estudante create(@RequestBody Estudante estudante){
       return service.create(estudante);
    }

    @PutMapping("/atualizar/{id}")
    public Estudante atualizar(@PathVariable UUID id, @RequestBody Estudante estudante){
        return service.atualizar(estudante, id);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }



}
