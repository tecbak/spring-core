package ua.rud.loggers;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.rud.beans.Event;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    @Autowired
    public FileEventLogger(@Value("log.txt") String fileName) {
        this.fileName = fileName;
    }

    @PostConstruct
    private void init() throws IOException {
        this.file = new File(fileName);
        if (!file.canWrite()) {
            throw new IOException();
        }
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.getMessage(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
