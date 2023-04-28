package entity;

import java.sql.Timestamp;

public class Appointment {
    private int appID;
    private int caseID;
    private Timestamp time;
    private String Title;
    private String description;

    public Appointment(int caseID, Timestamp time, String title, String description) {
        this.caseID = caseID;
        this.time = time;
        Title = title;
        this.description = description;
    }

    public Appointment(){}
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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
