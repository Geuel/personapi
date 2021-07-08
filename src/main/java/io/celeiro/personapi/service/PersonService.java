package io.celeiro.personapi.service;

import io.celeiro.personapi.dto.PersonDTO;
import io.celeiro.personapi.dto.message.MessageResponseDTO;
import io.celeiro.personapi.entities.Person;
import io.celeiro.personapi.mapper.PersonMapper;
import io.celeiro.personapi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public MessageResponseDTO insert(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .person("Created person with ID " + savedPerson.getId())
                .build();
    }
}
