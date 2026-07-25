package br.erudio.mapper.custom;

import br.erudio.data.dto.v2.PersonDtoV2;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

    public PersonDtoV2 convertEntityDTO(PersonDtoV2 person){

        PersonDtoV2 dto = new PersonDtoV2();
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        //dto.setDataNascimento(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());

        return dto;
    }

}
