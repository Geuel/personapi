package io.celeiro.personapi.dto.message;

import io.celeiro.personapi.entities.Person;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

    private Person person;
}
