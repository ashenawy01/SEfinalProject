package entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LawyerAssistant extends User {
    private boolean isSuperVisor;
    private List<Report> reports;
    private List<Appointment> appointments;

    public LawyerAssistant(String firstName, String lastName, String email,  String password,  String phoneNo,  boolean isActive, boolean isSuperVisor) {
        super(firstName, lastName, email, password, phoneNo, isActive);
        this.isSuperVisor = isSuperVisor;
        appointments = new ArrayList<>();
    }

    public LawyerAssistant(){}
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

    public boolean addAppointment(Appointment appointment) {
        return appointments.add(appointment);
    }
    public boolean deleteAppointment(Appointment appointment) {
        return appointments.remove(appointment);
    }
    public boolean deleteAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppID() == id) {
                return appointments.remove(appointment);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.getId() +
                ", firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", phoneNo='" + this.getPhoneNo() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", createdAt=" + this.getCreatedAt() + '\'' +
                ", isActive=" + this.isActive()  + '\'' +
                ", isSuperVisor=" + this.isSuperVisor  + '\'' +
                '}';
    }
}
