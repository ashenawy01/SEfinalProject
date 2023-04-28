package entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Reminder {
    private int remID;
    private int appointmentID;
    private String title;
    private Timestamp time;

    public Reminder(int appointmentID, String title, Timestamp time) {
        this.appointmentID = appointmentID;
        this.title = title;
        this.time = time;
    }
    public Reminder () {

    }

    public int getRemID() {
        return remID;
    }

    public void setRemID(int remID) {
        this.remID = remID;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
