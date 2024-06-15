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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.artec.config.ApiResponse;
import ec.artec.config.EventCreationException;
import ec.artec.config.ResourceNotFoundException;
import ec.artec.model.entities.Events;
import ec.artec.model.entities.Person;
import ec.artec.service.EventService;

@RestController
@RequestMapping("/events")
public class EventRest {

  @Autowired
  private EventService eventService;

  @PostMapping(value = "/createEvent")
  public ResponseEntity<ApiResponse<Events>> createEvent(@RequestBody Events eventToCreate) throws Exception {
    try {
      Events createdEvent = eventService.createEvent(eventToCreate);
      ApiResponse<Events> response = new ApiResponse<>("OK", HttpStatus.OK.value(), createdEvent);
      return ResponseEntity.ok(response);
    } catch (EventCreationException ex) {
      String error = "Error, revise la estructura: " + ex.toString();
      ApiResponse<Events> response = new ApiResponse<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(value = "/findEventByCode/{code}")
  public ResponseEntity<ApiResponse<Events>> findEventByCode(@PathVariable String code) {
    try {
      Events foundEvent = eventService.findEventCode(code);
      if (foundEvent != null) {
        ApiResponse<Events> response = new ApiResponse<>("OK", HttpStatus.OK.value(), foundEvent);
        return ResponseEntity.ok(response);
      } else {
        throw new ResourceNotFoundException("Evento no encontrado");
      }
    } catch (ResourceNotFoundException ex) {
      String error = "Error, revise la estructura: " + ex.toString();
      ApiResponse<Events> response = new ApiResponse<>("ERROR", HttpStatus.NOT_FOUND.value(), error);
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

  }

  @GetMapping(value = "/findEventByName")
  public ResponseEntity<ApiResponse<Events>> findEventByName(@RequestParam String name) {
    try {
      Events foundEvent = eventService.findEventName(name);
      if (foundEvent != null) {
        ApiResponse<Events> response = new ApiResponse<>("OK", HttpStatus.OK.value(), foundEvent);
        return ResponseEntity.ok(response);
      } else {
        throw new ResourceNotFoundException("Evento no encontrado");
      }
    } catch (ResourceNotFoundException ex) {
      String error = "Error, revise la estructura: " + ex.toString();
      ApiResponse<Events> response = new ApiResponse<>("ERROR", HttpStatus.NOT_FOUND.value(), error);
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
  }
}
