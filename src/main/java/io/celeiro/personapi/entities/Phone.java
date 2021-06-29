package io.celeiro.personapi.entities;

import io.celeiro.personapi.enums.PhoneType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_phone")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
