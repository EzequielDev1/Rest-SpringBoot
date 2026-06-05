package br.erudio.controllers;

import br.erudio.dto.PersonDto;
import br.erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PersonDto")
public class PersonController {

    @Autowired
    private PersonService service;

    //  Buscar por ID
    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable Long id){
        return service.findById(id);
    }

    // Criar
    @PostMapping
    public PersonDto create(@RequestBody PersonDto PersonDto){
        return service.create(PersonDto);
    }

    //  Listar todos
    @GetMapping
    public List<PersonDto> findAll(){
        return service.findAll();
    }

    //  Deletar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.Delete(id);
    }

    //  Atualizar
    @PutMapping("/{id}")
    public PersonDto update(@PathVariable Long id, @RequestBody PersonDto personDto){
        return service.Update(personDto, id);
    }
}