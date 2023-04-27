package entity;

import java.time.LocalDateTime;
import java.util.List;

public class LawyerAssistant extends User{
    private boolean isSuperVisor;
    private List<Report> reports;
    private List<Appointments> appointments;

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

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }

    public boolean addReports(List<Report> newReports) {
        if (newReports == null) {
            return false;
        }

        boolean added = false;
        for (Report report : newReports) {
            if (!reportList.contains(report)) {
                reportList.add(report);
                added = true;
            }
        }

        return added;
}

    public boolean deleteReportById(int reportId) {
        boolean deleted = false;
        Iterator<Report> it = reportList.iterator();
        while (it.hasNext()) {
            Report report = it.next();
            if (report.getId() == reportId) {
                it.remove();
                deleted = true;
                break;
            }
        }
        return deleted;
    }
