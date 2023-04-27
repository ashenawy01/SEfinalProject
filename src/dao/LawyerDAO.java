//package dao;
//
//import entity.Lawyer;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class LawyerDAO {
//    private final String url = "jdbc:derby:Database/LAWFIRMDB;";
//
//    // Save lawyer attributes in table lawyer
//    public boolean save(Lawyer lawyer) {
//
//        // Insert data sql statement
//        String sql = "INSERT INTO LAWYER (ID, EXPERIENCEYEAR, LAWTYPE, ISSENIOR, ISAVAILABLE)" +
//                " VALUES (?, ?, ?, ?, ?)";
//
//        // Connect to Database
//        try (Connection conn = DriverManager.getConnection(url);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            // Add the variable from the input object to the table
//            pstmt.setInt(1, lawyer.getId());
//            pstmt.setInt(2, lawyer.getExperienceYear());
////            pstmt.setInt();
//            // the number of inserted rows (i) if true & (0) if false
//            return pstmt.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    // Delete Lawyer by his ID
//    public boolean deleteLawyerById(int id) {
//        // The executed query
//        String sql = "DELETE FROM LAWYER WHERE ID = " + id;
//
//        // Connect to database
//        try (Connection connection = DriverManager.getConnection(url);
//             Statement statement = connection.createStatement()) {
//            // the affected number of raws (if > 0 the row is deleted)
//            return statement.executeUpdate(sql) > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    // Update Lawyer by ID Parm(Lawyer id , the new object of lawyer)
//    public boolean updateLawyerById(int id, Lawyer newlawyer) {
//
//        // The executed query (Note id cannot be updated)
//        String sql = "UPDATE LAWYER " +
//                "SET ISGLOBAL = ?" +
//                "WHERE ID = ?";
//
//        // Connect to Database
//        try (Connection connection = DriverManager.getConnection(url);
//             PreparedStatement pstmt = connection.prepareStatement(sql)) {
//
//            // add the new variable from the input object
//            pstmt.setBoolean(1, newlawyer.isGlobal());
//            pstmt.setInt(2, id);
//
//            // the affected number of raws (if > 0 the row is updated)
//            return pstmt.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false; // return false
//    }
//
//    // Retrieve all lawyers
//    public List<Lawyer> findAll() {
//        // List to store all the retrieved objects (Lawyers)
//        List<Lawyer> lawyers = new ArrayList<>();
//        // The executed query
//        String sql = "select * from ADMIN";
//        // lawyer to present each retrieved lawyer
//        Lawyer lawyer = new Lawyer();
//
//        // Connect to database
//        try (Connection connection = DriverManager.getConnection(url);
//             Statement statement = connection.createStatement()) {
//
//            // Get all rows
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) { // for each row (Lawyer)
//                lawyer.setId(resultSet.getInt("ID"));
//                lawyer.setGlobal(resultSet.getBoolean("ISGLOBAL"));
//                lawyers.add(lawyer); // Add lawyer to the list
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return lawyers; // return the retrieved list
//    }
//
//
//
//}
