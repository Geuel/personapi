package io.celeiro.personapi.service;

import io.celeiro.personapi.dto.PersonDTO;
import io.celeiro.personapi.dto.message.MessageResponseDTO;
import io.celeiro.personapi.entities.Person;
import io.celeiro.personapi.exception.PersonNotFoundException;
import io.celeiro.personapi.mapper.PersonMapper;
import io.celeiro.personapi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public List<PersonDTO> listAll() {
        List<Person> peopleToList = personRepository.findAll();
        return  peopleToList.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());

    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
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
