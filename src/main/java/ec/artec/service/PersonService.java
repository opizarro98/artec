package ec.artec.service;

import ec.artec.model.entities.Person;

public interface PersonService {
    
    public Person createPerson(Person person);

    public Person loginPerson(String username,  String password);
}
