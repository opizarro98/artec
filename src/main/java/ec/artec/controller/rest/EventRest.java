package ec.artec.controller.rest;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestAttribute;

import ec.artec.model.entities.Events;
import ec.artec.service.EventService;

@RestController
@RequestMapping("/events")
public class EventRest {

  @Autowired
  private EventService eventService;

  @PostMapping(value = "/createEvent")
  @ResponseBody
  public ResponseEntity<Events> createDataEvent(@RequestBody Events eventToCreate) throws Exception {
    System.out.println("entro adasdada" + eventToCreate.getDescription());
    try {
      return ResponseEntity.ok(eventService.createEvent(eventToCreate));
    } catch (DataAccessException ex) {
      String error = "Error, revise la estructura" + ex.toString();
      throw new Exception(error);
    }
  }

  @GetMapping(value = "/findDataEvenToCode/{code}")
  @ResponseBody
  public ResponseEntity<Events> findDataEvenToCode(@PathVariable String code) throws Exception {
    try {
      Events dataEvent = eventService.findEventCode(code);
      return ResponseEntity.ok(dataEvent);
    } catch (DataAccessException e) {
      throw new Exception(e);
    }
  }

  @GetMapping(value = "/findDataEvenToName")
  @ResponseBody
  public ResponseEntity<Events> findDataEvenToName(@RequestParam String name) throws Exception {
    try {
      Events dataEvent = eventService.findEventName(name);
      return ResponseEntity.ok(dataEvent);
    } catch (DataAccessException e) {
      throw new Exception(e);
    }
  }

}
