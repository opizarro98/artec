package ec.artec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.artec.model.entities.Person;
import ec.artec.repository.PersonRepository;
import ec.artec.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    public PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person loginPerson(String username, String password) {
        
        Person personLogin = personRepository.findByUserName(username);
        if(personLogin != null){
            if(personLogin.getPassword().equalsIgnoreCase(password)){
                return personLogin;
            }else{
                return null;
            }
        }
        return null;
    }
    
}
