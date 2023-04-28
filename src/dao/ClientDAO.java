package dao;

import entity.Client;
import entity.LawType;
import entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {


    private final String url = "jdbc:derby:Database/LAWFIRMDB;";

    // Save lawyer attributes in table lawyer
    public boolean save(Client client) {

        // Insert data sql statement
        String sql = "INSERT INTO CLIENT (firstName, lastName, phoneNo) VALUES(?,?,?)";


        // Connect to Database
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Add the variable from the input object to the table
            pstmt.setString(1, client.getFirstName());
            pstmt.setString(2, client.getLastName());
            pstmt.setString(3, client.getPhoneNo());

            // the number of inserted rows (i) if true & (0) if false
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //default return (if exception thrown)
    }


    // Delete client by his ID
    public boolean deleteClientById(int id) {
        // The executed query
        String sql = "DELETE FROM CLIENT WHERE ID = " + id;

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


    // Update client by ID Parm(client id , the new object of lawyer)
    public boolean updateClientById(int id, Client newClient) {

        // The executed query (Note id cannot be updated)
        String sql = "UPDATE CLIENT set FIRSTNAME = ?, LASTNAME = ?, PHONENO = ? WHERE ID = " + id;

        // Connect to Database
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // add the new variable from the input object
            pstmt.setString(1, newClient.getFirstName());
            pstmt.setString(2, newClient.getLastName());
            pstmt.setString(3, newClient.getPhoneNo());

            // the affected number of raws (if > 0 the row is updated)
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  //default return (if exception thrown)
    }


    // Retrieve all lawyers
    public List<Client> findAll() {
        // List to store all the retrieved objects (clients)
        List<Client> clients = new ArrayList<>();
        // The executed query
        String sql = "select * from LAWYER";
        // lawyer to present each retrieved lawyer
        Client client = new Client();

        LawType[] lawTypes = LawType.values();
        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {


            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // for each row (client)
                client.setClientID(resultSet.getInt("ID"));
                client.setFirstName(resultSet.getString("FIRSTNAME"));
                client.setLastName(resultSet.getString("LASTNAME"));
                client.setPhoneNo(resultSet.getString("PHONENO"));
                clients.add(client); // Add lawyer to the list
            }
            return clients; // return the retrieved list

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }


    // Retrieve lawyer by ID
    public Client findById(int id) {
        // The executed query
        String sql = "select * from LAWYER where ID = " + id;
        // lawyer to present each retrieved lawyer
        Client client = new Client();
        LawType [] lawTypes = LawType.values();

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) { // for each row (client)
                client.setClientID(resultSet.getInt("ID"));
                client.setFirstName(resultSet.getString("FIRSTNAME"));
                client.setLastName(resultSet.getString("LASTNAME"));
                client.setPhoneNo(resultSet.getString("PHONENO"));
            }
            return client; // return the retrieved lawyer
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }

}
