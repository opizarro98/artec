package ec.artec.service.impl;

import org.hibernate.TransientPropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.artec.model.entities.Events;
import ec.artec.repository.EventRepository;
import ec.artec.service.EventService;

@Service
public class EventServiceImpl implements EventService {

  @Autowired
  private EventRepository eventRepository;

  @Override
  public Events createEvent(Events event) throws Exception {
    try {
      return eventRepository.save(event);
    } catch (TransientPropertyValueException ex) {
      throw new Exception("Error: No se puede guardar el evento debido a una referencia a una categoría no persistida.",
          ex);
    } catch (Exception ex) {
      throw new Exception("Error al crear el evento.", ex);
    }
  }

  @Override
  public Events findEventCode(String code) {
    return eventRepository.findByCode(code);
  }

  @Override
  public Events findEventName(String name) {
    return eventRepository.findByName(name);
  }

}
