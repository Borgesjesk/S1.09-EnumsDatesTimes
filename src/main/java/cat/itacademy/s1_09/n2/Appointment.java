package cat.itacademy.s1_09.n2;

import java.time.LocalDateTime;

public class Appointment {

    private final String title;
    private final LocalDateTime dateTime;

    public Appointment(String title, LocalDateTime dateTime) {
        this.title = title;
        this.dateTime = dateTime;
    }

    public String getTitle() { return title; }
    public LocalDateTime getDateTime() { return dateTime; }

    @Override
    public String toString() {
        return "Appointment{title='" + title + "', dateTime=" + dateTime + "}";
    }
}