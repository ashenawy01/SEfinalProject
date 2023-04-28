package dao;

import entity.LawType;
import entity.Lawyer;
import entity.LawyerAssistant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LawyerAssistDAO {

    static final String url = "jdbc:derby:Database/LAWFIRMDB;";

    // Save LawyerAssist attributes in table LawyerAssist
    public static boolean save(LawyerAssistant LawAss) {

        // Insert data sql statement
        String sql = "INSERT INTO LAWYERASSIST (ID, ISSUPERVISOR)" +
                " VALUES (?, ?)";

        // Connect to Database
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Add the variable from the input object to the table
            pstmt.setInt(1, LawAss.getId());
            pstmt.setBoolean(2, LawAss.isSuperVisor());
            // the number of inserted rows (i) if true & (0) if false
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete lawAssist by his ID
    public boolean deleteLawyerAssistById(int id) {
        // The executed query
        String sql = "DELETE FROM LAWYERASSIST WHERE ID = " + id;

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            // the affected number of raws (if > 0 the row is deleted)
            return statement.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update LawyerAssistant by ID Parm(LawyerAssist id , the new object of LawyerAssist)
    public boolean updateLawyerAssistById(int id, LawyerAssistant newLawyerAssist) {

        // The executed query (Note id cannot be updated)
        String sql = "UPDATE LAWYERASSIST " +
                "SET ISSUPERVISOR = ?" +
                "WHERE ID = ?";

        // Connect to Database
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // add the new variable from the input object
            pstmt.setBoolean(1, newLawyerAssist.isSuperVisor());
            pstmt.setInt(2, id);

            // the affected number of raws (if > 0 the row is updated)
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // return false
    }

    // Retrieve all lawyerAssists
    public List<LawyerAssistant> findAll() {
        // List to store all the retrieved objects (LawyerAssist)
        List<LawyerAssistant> lawyerAssistants = new ArrayList<>();
        // The executed query
        String sql = "select * from LAWYERASSIST";

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // for each row (LawyerAssistant)
                LawyerAssistant lawAssist = new LawyerAssistant();
                lawAssist.setId(resultSet.getInt("ID"));
                lawAssist.setSuperVisor(resultSet.getBoolean("ISSUPERVISOR"));
                lawyerAssistants.add(lawAssist); // Add LawyerAssist to the list
            }
            return lawyerAssistants; // return the retrieved list

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }


    // Retrieve lawyer by ID
    public LawyerAssistant findById(int id) {
        // The executed query
        String sql = "select * from LAWYERASSIST where ID = " + id;
        // lawyer to present each retrieved lawyer
        LawyerAssistant lawyerAssist = new LawyerAssistant();

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) { // for each row (LawyerAssistant)
                lawyerAssist.setId(resultSet.getInt("ID"));
                lawyerAssist.setSuperVisor(resultSet.getBoolean("ISSUPERVISOR"));
                return lawyerAssist; // return the retrieved lawyer
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }
}
