package br.erudio.service;

import br.erudio.Repository.PersonRepository;
import br.erudio.dto.PersonDto;
import br.erudio.exception.hadler.ResourceNotFoundException;
import br.erudio.mapper.ObectMapper;
import br.erudio.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import static br.erudio.mapper.ObectMapper.parseObejct;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());
    private List<Person> people = new ArrayList<>();

    @Autowired
    PersonRepository repository;


    // 📤 Listar todos
    public List<PersonDto> findAll(){
        logger.info("Finding all PersonDtos");


        return ObectMapper.parseListObejct(repository.findAll(), PersonDto.class);

    }

    // 🔍 Buscar por ID
    public PersonDto findById(Long id){
        logger.info("Finding one PersonDto");

        var entity = repository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("No record Id"));

       return parseObejct(entity, PersonDto.class);
    }

    // 📥 Criar
    public PersonDto create(PersonDto person) {
        logger.info("Creating one PersonDto");

        var entity = parseObejct(person, Person.class);

        return parseObejct(repository.save(entity), PersonDto.class); // ✅ adicionado segundo argumento
    }

    // ✏️ Atualizar
    public PersonDto Update(PersonDto person, Long id) {
        logger.info("Updating one PersonDto");

        Person entity = repository.findById(person.getId()) // ✅ tipo correto: Person
                .orElseThrow(() -> new ResourceNotFoundException("No record Id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObejct(repository.save(entity), PersonDto.class);
    }

    // 🗑️ Deletar
    public void Delete(Long id) {
        logger.info("Deleting one PersonDto");

        Person entity = repository.findById(id) // ✅ tipo correto: Person
                .orElseThrow(() -> new ResourceNotFoundException("No record Id"));

        repository.delete(entity);
    }
}