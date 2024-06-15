package ec.artec.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.artec.config.ApiResponse;
import ec.artec.config.ResourceNotFoundException;
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
  public ResponseEntity<ApiResponse<Person>> createDataEvent(@RequestBody Person person) {
    try {
      Person createdPerson = personService.createPerson(person);
      ApiResponse<Person> response = new ApiResponse<>("OK", HttpStatus.OK.value(), createdPerson);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (DataAccessException ex) {
      String error = "Error, revise la estructura: " + ex.toString();
      ApiResponse<Person> response = new ApiResponse<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(value = "/login/{username}/{password}")
  @ResponseBody
  public ResponseEntity<ApiResponse<Person>> loginPlataform(@PathVariable String username,
      @PathVariable String password) {
    try {
      Person personaLogin = personService.loginPerson(username, password);
      ApiResponse<Person> response;
      if (personaLogin != null) {
        response = new ApiResponse<>("OK", HttpStatus.OK.value(), personaLogin);
        return new ResponseEntity<>(response, HttpStatus.OK);
      } else {
        throw new ResourceNotFoundException("Usuario o contraseña inválida");
      }
    } catch (DataAccessException ex) {
      String error = "Error, revise la estructura: " + ex.toString();
      ApiResponse<Person> response = new ApiResponse<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}