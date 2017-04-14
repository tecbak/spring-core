package ua.rud.loggers;

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
