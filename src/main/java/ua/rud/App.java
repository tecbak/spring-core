package ua.rud;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.rud.beans.Client;
import ua.rud.beans.Event;
import ua.rud.loggers.EventLogger;
import ua.rud.loggers.EventType;

import java.util.Map;

import static ua.rud.loggers.EventType.*;

public class App {
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    public void logEvent(Event event, EventType type) {
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultLogger;
        }
        String message = event.getMessage();
        event.setMessage(message.replaceAll(client.getId(), client.getFullName()));
        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = context.getBean("app", App.class);
        Event event = context.getBean("event", Event.class);
        event.setMessage("Some event for user 1\n");

        app.logEvent(event, INFO);
        app.logEvent(event, ERROR);
        app.logEvent(event, null);

        context.close();
    }
}
