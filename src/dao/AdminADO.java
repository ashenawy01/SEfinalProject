package dao;

import entity.Admin;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminADO {

    private final String url = "jdbc:derby:Database/LAWFIRMDB;";

    // Save admin attributes in table admin
    public boolean save(Admin admin) {

        // Insert data sql statement
        String sql = "INSERT INTO ADMIN (ID, ISGLOBAL)" +
                " VALUES (?, ?)";

        // Connect to Database
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Add the variable from the input object to the table
            pstmt.setInt(1, admin.getId());
            pstmt.setBoolean(2, admin.isGlobal());
            // the number of inserted rows (i) if true & (0) if false
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete Admin by his ID
    public boolean deleteAdminById(int id) {
        // The executed query
        String sql = "DELETE FROM ADMIN WHERE ID = " + id;

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

    // Update Admin by ID Parm(Admin id , the new object of admin)
    public boolean updateAdminById(int id, Admin newadmin) {

        // The executed query (Note id cannot be updated)
        String sql = "UPDATE ADMIN " +
                "SET ISGLOBAL = ?" +
                "WHERE ID = ?";

        // Connect to Database
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // add the new variable from the input object
            pstmt.setBoolean(1, newadmin.isGlobal());
            pstmt.setInt(2, id);

            // the affected number of raws (if > 0 the row is updated)
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // return false
    }

    // Retrieve all admins
    public List<Admin> findAll() {
        // List to store all the retrieved objects (Admins)
        List<Admin> admins = new ArrayList<>();
        // The executed query
        String sql = "select * from ADMIN";
        // admin to present each retrieved admin
        Admin admin = new Admin();

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // for each row (Admin)
                admin.setId(resultSet.getInt("ID"));
                admin.setGlobal(resultSet.getBoolean("ISGLOBAL"));
                admins.add(admin); // Add admin to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins; // return the retrieved list
    }
}
