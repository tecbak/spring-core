package ua.rud.beans;

import java.text.DateFormat;
import java.util.Date;

public class Event {
    private static int nextId = 0;

    private int id = nextId++;
    private String message;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return dateFormat.format(date);
    }
}
