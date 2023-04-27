package entity;

import java.time.LocalDateTime;
import java.util.List;

public class LawyerAssistant extends User {
    private boolean isSuperVisor;
    private List<Report> reports;
    private List<Appointment> appointments;

    public LawyerAssistant(String firstName, String lastName, String email, String phoneNo, String password, LocalDateTime createdAt, boolean isActive, boolean isSuperVisor) {
        super(firstName, lastName, email, phoneNo, password, createdAt, isActive);
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
