package ua.rud.loggers;

import org.springframework.stereotype.Component;
import ua.rud.beans.Event;

@Component
public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event.getMessage());
    }
}
