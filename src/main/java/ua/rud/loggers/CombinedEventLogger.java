package ua.rud.loggers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.rud.beans.Event;

import java.util.List;

public class CombinedEventLogger implements EventLogger {
    private List<EventLogger> eventLoggers;

    public CombinedEventLogger(List<EventLogger> eventLoggers) {
        this.eventLoggers = eventLoggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger : eventLoggers) {
            eventLogger.logEvent(event);
        }
    }
}
