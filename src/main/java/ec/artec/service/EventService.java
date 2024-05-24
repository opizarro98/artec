package ec.artec.service;

import ec.artec.model.entities.Events;

public interface EventService {

  public Events createEvent(Events event) throws Exception;

  public Events findEventCode(String code);

  public Events findEventName(String name);
}
