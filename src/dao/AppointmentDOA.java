package dao;


import entity.Appointment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AppointmentDOA {
    private final String url = "jdbc:derby:Database/LAWFIRMDB;";

    // Save appointment attributes in table appointment
    public boolean save(Appointment appointment) {

        // Insert data sql statement
        String sql = "INSERT INTO APPOINTMENT (CASEID, TITLE, DESCRIPTION, DATE)" +
                " VALUES (?, ?, ?, ?)";

        // Connect to Database
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Add the variable from the input object to the table
            pstmt.setInt(1, appointment.getCaseID());
            pstmt.setString(2, appointment.getTitle());
            pstmt.setString(3, appointment.getDescription());
            pstmt.setTimestamp(4, appointment.getTime());
            // the number of inserted rows (i) if true & (0) if false
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //default return (if exception thrown)
    }

    // Delete appointment by ID
    public boolean deleteAppointmentById(int id) {
        // The executed query
        String sql = "DELETE FROM APPOINTMENT WHERE ID = " + id;

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            // the affected number of raws (if > 0 the row is deleted)
            return statement.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //default return (if exception thrown)
    }

    // Update Appointment by ID (Appointment id , the new object of appointment)
    public boolean updateAppointmentById(int id, Appointment newappointment) {

        // The executed query (Note id cannot be updated)
        String sql = "UPDATE APPOINTMENT " +
                "SET CASEID = ?, TITLE = ?, DESCRIPTION = ?, DATE =? " +
                "WHERE ID = " + id;

        // Connect to Database
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // add the new variable from the input object
            pstmt.setInt(1, newappointment.getCaseID());
            pstmt.setString(2, newappointment.getTitle());
            pstmt.setString(3, newappointment.getDescription());
            pstmt.setTimestamp(4, newappointment.getTime());

            // the affected number of raws (if > 0 the row is updated)
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //default return (if exception thrown)
    }

    // Retrieve all appointments
    public List<Appointment> findAll() {
        // List to store all the retrieved objects (Appointments)
        List<Appointment> appointments = new ArrayList<>();
        // The executed query
        String sql = "select * from APPOINTMENT";
        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // for each row (Appointment)
                Appointment appointment = new Appointment();
                appointment.setAppID(resultSet.getInt("ID"));
                appointment.setCaseID(resultSet.getInt("CASEID"));
                appointment.setTitle(resultSet.getString("TITLE"));
                appointment.setDescription(resultSet.getString("DESCRIPTION"));
                appointment.setTime(resultSet.getTimestamp("DATE"));
                appointments.add(appointment); // Add appointment to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; //default return (if exception thrown)
        }
        return appointments; // return the retrieved list
    }

}
