package com.example.MiapiEnzoRH.services;

import com.example.MiapiEnzoRH.entities.Person;
import com.example.MiapiEnzoRH.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PersonaService implements BaseService<Person> {
    //@Autowired Permite que spring llame a las dependencias necesarias.
    private PersonRepository personRepository;

    //Tambien puede hacerse con el constructor, este no es llamado, Spring se encarga de trae las dependencias necesarias.
    public PersonaService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    //Esta anotacion te ahorra tener que aclarar y codear que son transactional
    @Transactional
    public List<Person> findAll() throws Exception {
        try{
            List<Person> entities = personRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Person findById(Long id) throws Exception {
        try{
            //Optional por que no sabemos si la entidad esta en la bd.
            Optional<Person> entityOptinal = personRepository.findById(id);
            return entityOptinal.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Person save(Person entity) throws Exception {
        try{
            entity = personRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Person update(Long id, Person entity) throws Exception {
        try{
            Optional<Person> entityOptional = personRepository.findById(id);
            Person person = entityOptional.get();
            person = personRepository.save(person);
            return person;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(personRepository.existsById(id)){
                personRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
