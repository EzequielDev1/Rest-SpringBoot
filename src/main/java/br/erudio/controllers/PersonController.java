package br.erudio.controllers;

import br.erudio.model.Person;
import br.erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    //  Buscar por ID
    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id){
        return service.findById(id);
    }

    // Criar
    @PostMapping
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    //  Listar todos
    @GetMapping
    public List<Person> findAll(){
        return service.findAll();
    }

    //  Deletar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.Delete(id);
    }

    //  Atualizar
    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person){
        return service.Update(person, id);
    }
}