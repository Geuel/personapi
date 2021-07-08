package io.celeiro.personapi.controller;

import io.celeiro.personapi.dto.PersonDTO;
import io.celeiro.personapi.dto.message.MessageResponseDTO;
import io.celeiro.personapi.entities.Person;
import io.celeiro.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/people")
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO insert(@RequestBody @Valid PersonDTO personDTO) {
        return personService.insert(personDTO);
    }
}
