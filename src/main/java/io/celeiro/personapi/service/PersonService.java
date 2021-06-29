package io.celeiro.personapi.service;

import io.celeiro.personapi.dto.message.MessageResponseDTO;
import io.celeiro.personapi.entities.Person;
import io.celeiro.personapi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public MessageResponseDTO insert(Person person) {
        Person savePerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .person(savePerson)
                .build();
    }
}
