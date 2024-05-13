package com.example.MiapiEnzoRH.repositories;

import com.example.MiapiEnzoRH.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Recibe el tipo de entidad con la que va a tranakar y el tipo de key (id) que definimos.
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
