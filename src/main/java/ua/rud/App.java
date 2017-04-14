package ua.rud;

import ua.rud.beans.Client;
import ua.rud.loggers.EventLogger;

public class App {
    private Client client;
    private EventLogger eventLogger;

    public App() {
    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        App app = new App();

        app.logEvent("Some event for user 1");
    }
}
