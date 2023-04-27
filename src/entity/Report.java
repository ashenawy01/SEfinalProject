package entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Report {
    private int repID;
    private String name;
    private Timestamp date;
    private String content;

    public Report(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public int getRepID() {
        return repID;
    }

    public void setRepID(int repID) {
        this.repID = repID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
