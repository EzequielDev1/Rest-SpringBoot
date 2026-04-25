package br.erudio.service;

import br.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());
    private List<Person> people = new ArrayList<>();


    // 🔍 Buscar por ID
    public Person findById(String id){
        logger.info("Finding one Person");

        return people.stream()
                .filter(p -> p.getId().equals(Long.parseLong(id))) // Ele Filtra, só deixa passar igual o id
                .findFirst() // Pega o primeiro resultado encontrado
                .orElse(null);


    }

    // 📤 Listar todos
    public List<Person> findAll(){
        logger.info("Finding all Persons");
        return people;
    }

    // 📥 Criar
    public Person create(Person person){
        logger.info("Creating one Person");

        person.setId(counter.incrementAndGet());
        people.add(person);

        return person;
    }

    // ✏️ Atualizar
    public Person Update(Person person, String id){
        logger.info("Updating one Person");

        Person existing = findById(id);

        if(existing != null){
            existing.setFirstName(person.getFirstName());
            existing.setLastName(person.getLastName());
            existing.setGender(person.getGender());
            existing.setAddress(person.getAddress());
        }

        return existing;
    }

    // 🗑️ Deletar
    public void Delete(String id){
        logger.info("Deleting one Person");

        people.removeIf(p -> p.getId().equals(Long.parseLong(id)));
    }
}