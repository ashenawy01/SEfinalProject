package entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Document {
    private int docID;
    private String name;
    private Timestamp uploadTime;
    private int caseID;
    private int uploadBy;

    public Document(String name, int caseID, int uploadBy) {
        this.name = name;
        this.caseID = caseID;
        this.uploadBy = uploadBy;
        this.uploadTime = new Timestamp(System.currentTimeMillis());
    }

    public Document (){}
    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public int getUploadBy() {
        return uploadBy;
    }

    public void setUploadBy(int uploadBy) {
        this.uploadBy = uploadBy;
    }
}
