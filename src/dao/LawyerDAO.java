package dao;

import entity.LawType;
import entity.Lawyer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LawyerDAO {
    private final String url = "jdbc:derby:Database/LAWFIRMDB;";

    // Save lawyer attributes in table lawyer
    public boolean save(Lawyer lawyer) {

        // Insert data sql statement
        String sql = "INSERT INTO LAWYER (ID, EXPERIENCEYEAR, LAWTYPE, ISSENIOR, ISAVAILABLE)" +
                " VALUES (?, ?, ?, ?, ?)";

        // Connect to Database
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Add the variable from the input object to the table
            pstmt.setInt(1, lawyer.getId());
            pstmt.setInt(2, lawyer.getExperienceYear());
            pstmt.setInt(3, lawyer.getType().ordinal() + 1);
            pstmt.setBoolean(4, lawyer.isSenior());
            pstmt.setBoolean(5, lawyer.isAvialable());

            // the number of inserted rows (i) if true & (0) if false
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //default return (if exception thrown)
    }


    // Delete Lawyer by his ID
    public boolean deleteLawyerById(int id) {
        // The executed query
        String sql = "DELETE FROM LAWYER WHERE ID = " + id;

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

    // Update Lawyer by ID Parm(Lawyer id , the new object of lawyer)
    public boolean updateLawyerById(int id, Lawyer newlawyer) {

        // The executed query (Note id cannot be updated)
        String sql = "UPDATE LAWYER " +
                "SET EXPERIENCEYEAR = ?, LAWTYPE = ?, ISSENIOR = ?, ISAVAILABLE = ?" +
                "WHERE ID = ?";

        // Connect to Database
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // add the new variable from the input object
            pstmt.setInt(1, newlawyer.getExperienceYear());
            pstmt.setInt(2,newlawyer.getType().ordinal() + 1);
            pstmt.setBoolean(3, newlawyer.isSenior());
            pstmt.setBoolean(4, newlawyer.isAvialable());
            pstmt.setInt(5, id);

            // the affected number of raws (if > 0 the row is updated)
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  //default return (if exception thrown)
    }
    // Retrieve all lawyers
    public List<Lawyer> findAll() {
        // List to store all the retrieved objects (Lawyers)
        List<Lawyer> lawyers = new ArrayList<>();
        // The executed query
        String sql = "select * from LAWYER";

        LawType [] lawTypes = LawType.values();
        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {


            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // for each row (Lawyer)
                Lawyer lawyer = new Lawyer();
                lawyer.setId(resultSet.getInt("ID"));
                lawyer.setExperienceYear(resultSet.getInt("EXPERIENCEYEAR"));
                lawyer.setType(lawTypes[resultSet.getInt("LAWTYPE")]);
                lawyer.setSenior(resultSet.getBoolean("ISSENIOR"));
                lawyer.setAvialable(resultSet.getBoolean("ISAVAILABLE"));
                lawyers.add(lawyer); // Add lawyer to the list
            }
            return lawyers; // return the retrieved list

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }


    // Retrieve lawyer by ID
    public Lawyer findById(int id) {
        // The executed query
        String sql = "select * from LAWYER where ID = " + id;
        // lawyer to present each retrieved lawyer
        Lawyer lawyer = new Lawyer();
        LawType [] lawTypes = LawType.values();

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) { // for each row (Lawyer)
                lawyer.setId(resultSet.getInt("ID"));
                lawyer.setExperienceYear(resultSet.getInt("EXPERIENCEYEAR"));
                lawyer.setType(lawTypes[resultSet.getInt("LAWTYPE")]);
                lawyer.setSenior(resultSet.getBoolean("ISSENIOR"));
                lawyer.setAvialable(resultSet.getBoolean("ISAVAILABLE"));
                return lawyer; // return the retrieved lawyer
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }



}
