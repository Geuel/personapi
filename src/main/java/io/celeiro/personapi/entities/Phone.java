package io.celeiro.personapi.entities;

import io.celeiro.personapi.enums.PhoneType;
import lombok.*;

import javax.persistence.*;

@Entity @Builder @Data
@AllArgsConstructor @NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
