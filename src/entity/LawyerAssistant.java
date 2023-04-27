package entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class LawyerAssistant extends User {
    private boolean isSuperVisor;
    private List<Report> reports;
    private List<Appointment> appointments;

    public LawyerAssistant(String firstName, String lastName, String email, String phoneNo, String password, Timestamp createdAt, boolean isActive, boolean isSuperVisor) {
        super(firstName, lastName, email, password, phoneNo, isActive);
        this.isSuperVisor = isSuperVisor;
    }

    public boolean isSuperVisor() {
        return isSuperVisor;
    }

    public void setSuperVisor(boolean superVisor) {
        isSuperVisor = superVisor;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
