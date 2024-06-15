package ec.artec.service.impl;

import org.hibernate.TransientPropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.stereotype.Service;

import ec.artec.config.EventCreationException;
import ec.artec.config.ResourceNotFoundException;
import ec.artec.model.entities.Events;
import ec.artec.repository.EventRepository;
import ec.artec.service.EventService;

@Service
public class EventServiceImpl implements EventService {

  @Autowired
  private EventRepository eventRepository;

  @Override
  public Events createEvent(Events event) {
    try {
      return eventRepository.save(event);
    } catch (TransientDataAccessResourceException ex) {
      throw new EventCreationException(
          "Error: No se puede guardar el evento debido a una referencia a una categoría no persistida.", ex);
    } catch (Exception ex) {
      throw new EventCreationException("Error al crear el evento.", ex);
    }
  }

  @Override
  public Events findEventCode(String code) {
    Events event = eventRepository.findByCode(code);
    if (event == null) {
      throw new ResourceNotFoundException("Evento no encontrado con el código: " + code);
    }
    return event;
  }

  @Override
  public Events findEventName(String name) {
    Events event = eventRepository.findByName(name);
    if (event == null) {
      throw new ResourceNotFoundException("Evento no encontrado con el nombre: " + name);
    }
    return event;
  }
}