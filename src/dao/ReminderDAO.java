package dao;

import entity.Reminder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReminderDAO {


    private final String url = "jdbc:derby:Database/LAWFIRMDB;";

    // Save reminder attributes in table client
    public boolean save(Reminder reminder) {

        // Insert data sql statement
        String sql = "INSERT INTO REMINDER (appId, title, time) VALUES(?,?,?)";


        // Connect to Database
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Add the variable from the input object to the table
            pstmt.setInt(1, reminder.getAppointmentID());
            pstmt.setString(2, reminder.getTitle());
            pstmt.setTimestamp(3, reminder.getTime());

            // the number of inserted rows (i) if true & (0) if false
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //default return (if exception thrown)
    }


    // Delete reminder by his ID
    public boolean deleteReminderById(int id) {
        // The executed query
        String sql = "DELETE FROM REMINDER WHERE ID = " + id;

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            // the affected number of raws (if > 0 the row is deleted)
            return statement.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  //default return (if exception thrown)
    }


    // Update reminder by ID Parm(client id , the new object of client)
    public boolean updateClientById(int id, Reminder newReminder) {

        // The executed query (Note id cannot be updated)
        String sql = "UPDATE REMINDER set APPID = ?, TITLE = ?, TIME = ? WHERE ID = " + id;

        // Connect to Database
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // add the new variable from the input object
            pstmt.setInt(1, newReminder.getAppointmentID());
            pstmt.setString(2, newReminder.getTitle());
            pstmt.setTimestamp(3, newReminder.getTime());

            // the affected number of raws (if > 0 the row is updated)
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  //default return (if exception thrown)
    }


    // Retrieve all clients
    public List<Reminder> findAll() {
        // List to store all the retrieved objects (reminders)
        List<Reminder> reminders = new ArrayList<>();
        // The executed query
        String sql = "select * from REMINDER";
        // client to present each retrieved reminder
        Reminder reminder = new Reminder();


        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {


            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // for each row (client)
                reminder.setRemID(resultSet.getInt("ID"));
                reminder.setAppointmentID(resultSet.getInt("APPID"));
                reminder.setTitle(resultSet.getString("TITLE"));
                reminder.setTime(resultSet.getTimestamp("TIME"));
                reminders.add(reminder); // Add reminder to the list
            }
            return reminders; // return the retrieved list

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }


    // Retrieve client by ID
    public Reminder findById(int id) {
        // The executed query
        String sql = "select * from CLIENT where ID = " + id;
        // reminder to present each retrieved client
        Reminder reminder = new Reminder();

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) { // for each row (reminder)
                reminder.setRemID(resultSet.getInt("ID"));
                reminder.setAppointmentID(resultSet.getInt("APPID"));
                reminder.setTitle(resultSet.getString("TITLE"));
                reminder.setTime(resultSet.getTimestamp("TIME"));
            }
            return reminder; // return the retrieved client
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }
}
