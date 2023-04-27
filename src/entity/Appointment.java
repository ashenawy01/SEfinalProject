package entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Appointment {
    private int appID;
    private int caseID;
    private Timestamp date;
    private String Title;
    private String description;

    public Appointment(int caseID, String title, String description) {
        this.caseID = caseID;
        Title = title;
        this.description = description;
    }

    public int getAppID() {
        return appID;
    }

    public void setAppID(int appID) {
        this.appID = appID;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
