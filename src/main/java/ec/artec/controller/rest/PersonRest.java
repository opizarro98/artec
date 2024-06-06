package ec.artec.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.artec.model.entities.Person;
import ec.artec.service.PersonService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/person")
public class PersonRest {
    
    @Autowired
    public PersonService personService;

@PostMapping(value = "/registration")
  @ResponseBody
  public ResponseEntity<Person> createDataEvent(@RequestBody Person person) throws Exception {
    try {
      return ResponseEntity.ok(personService.createPerson(person));
    } catch (DataAccessException ex) {
      String error = "Error, revise la estructura" + ex.toString();
      throw new Exception(error);
    }
  }

  @GetMapping(value = "/login/{username}/{password}")
  @ResponseBody
  public ResponseEntity<Person> loginPlataform(@PathVariable String username, @PathVariable String password) throws Exception {
    try {
      return ResponseEntity.ok(personService.loginPerson(username, password));
    } catch (DataAccessException ex) {
      String error = "Error, revise la estructura" + ex.toString();
      throw new Exception(error);
    }
  }
}
