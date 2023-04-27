package entity;

import java.time.LocalDateTime;

public class Report {
    private int repID;
    private String name;
    private LocalDateTime date;
    private String content;

    public Report(String name, LocalDateTime date, String content) {
        this.name = name;
        this.date = date;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
