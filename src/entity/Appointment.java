package entity;

import java.time.LocalDateTime;

public class Appointment {
    private int appID;
    private int caseID;
    private LocalDateTime date;
    private String Title;
    private String description;

    public Appointment(int caseID, LocalDateTime date, String title, String description) {
        this.caseID = caseID;
        this.date = date;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
