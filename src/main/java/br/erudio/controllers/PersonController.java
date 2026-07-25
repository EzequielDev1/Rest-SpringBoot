package br.erudio.controllers;

import br.erudio.data.dto.v1.PersonDtoV1;
import br.erudio.data.dto.v2.PersonDtoV2;
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
    public PersonDtoV1 findById(@PathVariable Long id){
        return service.findById(id);
    }

    // Criar
    @PostMapping
    public PersonDtoV1 create(@RequestBody PersonDtoV1 PersonDto){
        return service.createV2(PersonDto);
    }

    //  Listar todos
    @GetMapping
    public List<PersonDtoV1> findAll(){
        return service.findAll();
    }

    //  Deletar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.Delete(id);
    }

    //  Atualizar
    @PutMapping("/{id}")
    public PersonDtoV1 update(@PathVariable Long id, @RequestBody PersonDtoV1 personDto){
        return service.Update(personDto, id);
    }


   /* @PostMapping("/{v2}")
    public PersonDtoV2 createV2(@RequestBody PersonDtoV2 person){
          return service.createV2(person);
    }*/
}