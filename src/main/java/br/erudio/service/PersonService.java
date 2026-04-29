package br.erudio.service;

import br.erudio.Repository.PersonRepository;
import br.erudio.exception.hadler.ResourceNotFoundException;
import br.erudio.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    PersonRepository repository;


    // 📤 Listar todos
    public List<Person> findAll(){
        logger.info("Finding all Persons");

        return repository.findAll();

    }

    // 🔍 Buscar por ID
    public Person findById(Long id){
        logger.info("Finding one Person");

        return repository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("No record Id"));


    }
    // 📥 Criar
    public Person create(Person person){
        logger.info("Creating one Person");

        return repository.save(person);
    }

    // ✏️ Atualizar
    public Person Update(Person person, Long id){
        logger.info("Updating one Person");

        Person entity =  repository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("No record Id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

       return repository.save(entity);
    }

    // 🗑️ Deletar
    public void Delete(Long id){
        logger.info("Deleting one Person");

      Person entity =  repository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("No record Id"));

      repository.delete(entity);
    }
}