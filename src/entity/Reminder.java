package entity;

import java.time.LocalDateTime;

public class Reminder {
    private int remID;
    private int appointmentID;
    private String title;
    private LocalDateTime time;

    public Reminder(int appointmentID, String title, LocalDateTime time) {
        this.appointmentID = appointmentID;
        this.title = title;
        this.time = time;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
