package br.erudio.controllers;

import br.erudio.model.Car;
import br.erudio.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class carController {

    @Autowired
    private CarService service;

    @PostMapping()
    public Car create(@RequestBody Car car){
        return service.create(car);
    }

    @GetMapping("/{id}")
    public Car BuscaPorId(@PathVariable String id){
       return service.FindById(id);
    }

    @GetMapping
    public List<Car> listaTodosCarros(@PathVariable String id, @RequestBody Car car){
        return service.findAll(id, car);

    }

    @PutMapping("/{id}")
     public Car alterar(@PathVariable String id, @RequestBody Car  car){
        return service.update(id, car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
