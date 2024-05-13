package com.example.MiapiEnzoRH.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.io.Serializable;
//Anotaciones de JPA
@Entity
@Table(name = "persona")
//Anotaciones de Lombok
@AllArgsConstructor
@Getter
@Setter
//Este es de hinvernate,
@Audited
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "dni")
    private int dni;
}
