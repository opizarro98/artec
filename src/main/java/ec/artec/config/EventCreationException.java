package ec.artec.config;

public class EventCreationException extends RuntimeException {
    public EventCreationException(String message) {
        super(message);
    }

    public EventCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public class EventNotFoundException extends RuntimeException {
        public EventNotFoundException(String message) {
            super(message);
        }

        public EventNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
