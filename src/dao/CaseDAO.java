package dao;

import entity.CaseCategory;
import entity.CaseState;
import entity.LawType;
import entity.Case;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaseDAO {
    private final String url = "jdbc:derby:Database/LAWFIRMDB;";

    // Save case attributes in table case
    public boolean save(Case newCase) {

        // Insert data sql statement
        String sql = "INSERT INTO LEGAL_CASE (NAME, DESCRIPTION, CREATEDAT, CASECATEGORY, CASESTATE, CLIENTID)" +
                " VALUES (?, ?, ?, ?, ?, ?)";

        // Connect to Database
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Add the variable from the input object to the table
            pstmt.setString(1, newCase.getName());
            pstmt.setString(2, newCase.getDescription());
            pstmt.setTimestamp(3, newCase.getCreatedAt());
            pstmt.setInt(4, newCase.getCaseCategory().ordinal() + 1);
            pstmt.setInt(5, newCase.getCaseState().ordinal() + 1);
            pstmt.setInt(6, newCase.getClientID());

            // the number of inserted rows (i) if true & (0) if false
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //default return (if exception thrown)
    }


    // Delete Case by his ID
    public boolean deleteCaseById(int id) {
        // The executed query
        String sql = "DELETE FROM LEGAL_CASE WHERE ID = " + id;

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

    // Update Case by ID Parm(Case id , the new object of case)
    public boolean updateCaseById(int id, Case newnewCase) {

        // The executed query (Note id cannot be updated)
        String sql = "UPDATE LEGAL_CASE " +
                "SET NAME = ?, DESCRIPTION = ?, CREATEDAT = ?, CASECATEGORY = ?, CASESTATE = ?, CLIENTID = ?" +
                "WHERE ID = " + id;

        // Connect to Database
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // add the new variable from the input object
            pstmt.setString(1, newnewCase.getName());
            pstmt.setString(2, newnewCase.getDescription());
            pstmt.setTimestamp(3, newnewCase.getCreatedAt());
            pstmt.setInt(4, newnewCase.getCaseCategory().ordinal() + 1);
            pstmt.setInt(5, newnewCase.getCaseState().ordinal() + 1);
            pstmt.setInt(6, newnewCase.getClientID());;

            // the affected number of raws (if > 0 the row is updated)
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  //default return (if exception thrown)
    }
    // Retrieve all cases
    public List<Case> findAll() {
        // List to store all the retrieved objects (Cases)
        List<Case> newCases = new ArrayList<>();
        // The executed query
        String sql = "select * from LEGAL_CASE";
        // case to present each retrieved case

        CaseCategory[] caseCategories = CaseCategory.values();
        CaseState[] caseStates = CaseState.values();
        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // for each row (Case)
                Case newCase = new Case();
                newCase.setCaseID(resultSet.getInt("ID"));
                newCase.setName(resultSet.getString("NAME"));
                newCase.setDescription(resultSet.getString("DESCRIPTION"));
                newCase.setCreatedAt(resultSet.getTimestamp("CREATEDAT"));
                newCase.setCaseCategory(caseCategories[resultSet.getInt("CASECATEGORY")]);
                newCase.setCaseState(caseStates[resultSet.getInt("CASESTATE")]);
                newCase.setCaseID(resultSet.getInt("CLIENTID"));
                newCases.add(newCase); // Add case to the list
            }
            return newCases; // return the retrieved list

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }


    // Retrieve case by ID
    public Case findById(int id) {
        // The executed query
        String sql = "select * from LEGAL_CASE where ID = " + id;
        // case to present each retrieved case
        Case newCase = new Case();

        CaseCategory[] caseCategories = CaseCategory.values();
        CaseState[] caseStates = CaseState.values();

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) { // for each row (Case)
                newCase.setCaseID(resultSet.getInt("ID"));
                newCase.setName(resultSet.getString("NAME"));
                newCase.setDescription(resultSet.getString("DESCRIPTION"));
                newCase.setCreatedAt(resultSet.getTimestamp("CREATEDAT"));
                newCase.setCaseCategory(caseCategories[resultSet.getInt("CASECATEGORY")]);
                newCase.setCaseState(caseStates[resultSet.getInt("CASESTATE")]);
                newCase.setCaseID(resultSet.getInt("CLIENTID"));
            }
            return newCase; // return the retrieved case
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }


}
