package br.erudio.service;

import br.erudio.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class CarService {

    AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(CarService.class.getName());

    List<Car> cars  = new ArrayList<>();

    // Create

    public Car create(Car car){
        logger.info("Creating one Car ");
        car.setId(counter.incrementAndGet());
        cars.add(car);
        return car;
    }

    // 🔍 Buscar por ID

    public Car FindById(String id){
        logger.info("Listing one Cars");

        return cars.stream()
                .filter(car1 ->  car1.getId().equals(id))
                .findFirst().orElse(null);

    }

    // Lista todos os carros

    public List<Car> findAll(String id, Car car){
        logger.info("Selecionando Cars");
        return  cars;
    }

    // Delete

    public void delete(String id){
        logger.info("Deleting one Car");
        cars.removeIf(car -> car.getId().equals(id));

    }

    // Update

    public Car update(String id, Car car){
        logger.info("UpDateing one Car");

        Car existing = FindById(id);

        if(existing != null ){
            existing.setName(car.getName());
            existing.setModel(car.getModel());
            existing.setYear(car.getYear());
        }
        return existing;
    }


}
