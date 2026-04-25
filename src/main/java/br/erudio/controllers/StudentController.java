package br.erudio.controllers;

import br.erudio.model.Student;
import br.erudio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;


    @PutMapping("/id")
    public Student atualizar(@PathVariable String id, @RequestBody Student student){
       return service.atualizar(id, student);
    }

    @PostMapping
    public Student create(@RequestBody Student student){
       return service.create(student);
    }

    @GetMapping
    public List<Student> Listar(){
        return service.Listar();
    }

    @GetMapping("/id")
    public Student BuscarPorID(@PathVariable String id){
        return service.BuscarPorId(id);
    }

    @DeleteMapping("/id")
    public void Delete(@PathVariable String id){
         service.Delete(id);
    }

}

