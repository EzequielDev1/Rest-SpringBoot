package br.erudio.service;

import br.erudio.Repository.PersonRepository;
import br.erudio.data.dto.v1.PersonDtoV1;
import br.erudio.data.dto.v2.PersonDtoV2;
import br.erudio.exception.hadler.ResourceNotFoundException;
import br.erudio.mapper.ObectMapper;
import br.erudio.mapper.custom.PersonMapper;
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

    @Autowired
    PersonMapper personMapper;

    // 📤 Listar todos
    public List<PersonDtoV1> findAll(){
        logger.info("Finding all PersonDtos");


        return ObectMapper.parseListObejct(repository.findAll(), PersonDtoV1.class);

    }

    // 🔍 Buscar por ID
    public PersonDtoV1 findById(Long id){
        logger.info("Finding one PersonDto");

        var entity = repository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("No record Id"));

       return parseObejct(entity, PersonDtoV1.class);
    }

    // V1
    public PersonDtoV1 createV2(PersonDtoV1 person) {
        logger.info("Creating one PersonDto");

        var entity = parseObejct(person, Person.class);

        return parseObejct(repository.save(entity), PersonDtoV1.class); // ✅ adicionado segundo argumento
    }

    //V2
  /*  public  PersonDtoV2 createV2(PersonDtoV2 person){

        var entity = personMapper.convertEntityDTO(person);

        return personMapper.convertEntityDTO(repository.save(entity);
    }*/
    // ✏️ Atualizar
    public PersonDtoV1 Update(PersonDtoV1 person, Long id) {
        logger.info("Updating one PersonDto");

        Person entity = repository.findById(person.getId()) // ✅ tipo correto: Person
                .orElseThrow(() -> new ResourceNotFoundException("No record Id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

            return parseObejct(repository.save(entity), PersonDtoV1.class);
        }

    // 🗑️ Deletar
    public void Delete(Long id) {
        logger.info("Deleting one PersonDto");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record Id"));

        repository.delete(entity);
    }
}