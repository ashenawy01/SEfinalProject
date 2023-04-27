package entity;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Case implements Comparable<Case>, Comparator<Case> {
    private int caseID;
    private String name;
    private String description;
    private List<Document> documents;
    private List<Lawyer> lawyers;
    private Timestamp createdAt;
    private CaseCategory caseCategory;
    private CaseState caseState;
    private int clientID;

    public Case(String name, String description, List<Document> documents, List<Lawyer> lawyers, Timestamp createdAt, CaseCategory caseCategory, CaseState caseState, int clientID) {
        this.name = name;
        this.description = description;
        this.documents = documents;
        this.lawyers = lawyers;
        this.createdAt = createdAt;
        this.caseCategory = caseCategory;
        this.caseState = caseState;
        this.clientID = clientID;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public CaseCategory getCaseCategory() {
        return caseCategory;
    }

    public void setCaseCategory(CaseCategory caseCategory) {
        this.caseCategory = caseCategory;
    }

    public CaseState getCaseState() {
        return caseState;
    }

    public void setCaseState(CaseState caseState) {
        this.caseState = caseState;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    @Override
    public int compareTo(Case caseObj) {
        return Integer.compare(this.caseID, caseObj.getCaseID());
    }

    @Override
    public int compare(Case o1, Case o2) {
        return Integer.compare(o1.getCaseID(), o2.getCaseID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Case aCase)) return false;
        return caseID == aCase.caseID && clientID == aCase.clientID && Objects.equals(name, aCase.name) && Objects.equals(description, aCase.description) && Objects.equals(documents, aCase.documents) && Objects.equals(lawyers, aCase.lawyers) && Objects.equals(createdAt, aCase.createdAt) && caseCategory == aCase.caseCategory && caseState == aCase.caseState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseID);
    }
}
