package dao;

import entity.Document;
import entity.Document;
import entity.LawType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentDAO {
    private final String url = "jdbc:derby:Database/LAWFIRMDB;";

    // Save document attributes in table document
    public boolean save(Document document) {

        // Insert data sql statement
        String sql = "INSERT INTO DOCUMENT (CASEID, NAME, UPLOADTIME, UPLOADBY)" +
                " VALUES (?, ?, ?, ?)";

        // Connect to Database
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Add the variable from the input object to the table
            pstmt.setInt(1, document.getCaseID());
            pstmt.setString(2, document.getName());
            pstmt.setTimestamp(3, document.getUploadTime());
            pstmt.setInt(4, document.getUploadBy());

            // the number of inserted rows (i) if true & (0) if false
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //default return (if exception thrown)
    }


    // Delete document by his ID
    public boolean deleteDocumentById(int id) {
        // The executed query
        String sql = "DELETE FROM DOCUMENT WHERE ID = " + id;

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


    // Update document by ID Parm(document id , the new object of document)
    public boolean updateDocumentById(int id, Document newDocument) {

        // The executed query (Note id cannot be updated)
        String sql = "UPDATE DOCUMENT " +
                "set CASEID = ?, NAME = ?, UPLOADTIME = ?, UPLOADBY = ? " +
                "WHERE ID = " + id;

        // Connect to Database
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // add the new variable from the input object
            pstmt.setInt(1, newDocument.getCaseID());
            pstmt.setString(2, newDocument.getName());
            pstmt.setTimestamp(3, newDocument.getUploadTime());
            pstmt.setInt(4, newDocument.getUploadBy());

            // the affected number of raws (if > 0 the row is updated)
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  //default return (if exception thrown)
    }


    // Retrieve all documents
    public List<Document> findAll() {
        // List to store all the retrieved objects (documents)
        List<Document> documents = new ArrayList<>();
        // The executed query
        String sql = "select * from DOCUMENT";
        // document to present each retrieved document
        Document document = new Document();

        LawType[] lawTypes = LawType.values();
        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // for each row (document)
                document.setDocID((resultSet.getInt("ID")));
                document.setCaseID((resultSet.getInt("CASEID")));
                document.setName((resultSet.getString("NAME")));
                document.setUploadTime((resultSet.getTimestamp("UPLOADTIME")));
                document.setUploadBy((resultSet.getInt("UPLOADBY")));
                documents.add(document); // Add document to the list
            }
            return documents; // return the retrieved list

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }


    // Retrieve document by ID
    public Document findById(int id) {
        // The executed query
        String sql = "select * from DOCUMENT where ID = " + id;
        // document to present each retrieved document
        Document document = new Document();

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) { // for the first row (document)
                document.setDocID((resultSet.getInt("ID")));
                document.setCaseID((resultSet.getInt("CASEID")));
                document.setName((resultSet.getString("NAME")));
                document.setUploadTime((resultSet.getTimestamp("UPLOADTIME")));
                document.setUploadBy((resultSet.getInt("UPLOADBY")));
            }
            return document; // return the retrieved document
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }


}
