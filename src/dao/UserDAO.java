package dao;

import entity.Admin;
import entity.Lawyer;
import entity.LawyerAssistant;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final String url = "jdbc:derby:Database/LAWFIRMDB;";

    // create new user
    public boolean save(User user) {
        // Insert data sql statement
        String sql = "INSERT INTO SYS_USER (firstname, lastname, email, pass, isactive)" +
                " VALUES (?, ?, ?, ?, ?)";
        // connect to database
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set user values
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setBoolean(5, user.isActive());
            // the number of inserted rows - (i) if true & (0) if false
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // default return is false (if any exception thrown)
    }


    /*
    * Find the user by ID
    * This is a Generic function
    * to find the user with type (Admin & Lawyer & LawyerAssist)
    * according to the given object parameter
    * */
    public <T>User findUserById (T object, int id) {

        // Get the type of user to find
        User user = null;
        if (object instanceof Admin) {
            user = new Admin();
        } else if (object instanceof Lawyer) {
            user = new Lawyer();
        } else if (object instanceof LawyerAssistant) {
            user = new LawyerAssistant();
        }

        // the executed query
        String sql = "SELECT * FROM SYS_USER WHERE ID = " + id;

        // connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // get the result
           ResultSet resultSet = statement.executeQuery(sql);

           // set user attributes
            if (resultSet.next()) {
               user.setId(resultSet.getInt("ID"));
               user.setFirstName(resultSet.getString("FIRSTNAME"));
               user.setLastName(resultSet.getString("LASTNAME"));
               user.setEmail(resultSet.getString("EMAIL"));
               user.setPassword(resultSet.getString("PASS"));
               user.setActive(resultSet.getBoolean("ISACTIVE"));
               user.setCreatedAt(resultSet.getTimestamp("CREATEDAT"));
           }

        } catch (SQLException e) {
            e.printStackTrace();
            return null; // If exception thrown
        }
        return user; // return user
    }


    /*
     * Find the user by email
     * This is a Generic function
     * to find the user with type (Admin & Lawyer & LawyerAssist)
     * according to the given object parameter
     * Note : Email is set to be  unique in Database already
     * */
    public <T>User findUserByEmail (T object, String email) {

        // Get the type of user to find
        User user = null;
        if (object instanceof Admin) {
            user = new Admin();
        } else if (object instanceof Lawyer) {
            user = new Lawyer();
        } else if (object instanceof LawyerAssistant) {
            user = new LawyerAssistant();
        }

        // the executed query
        String sql = "SELECT * FROM SYS_USER WHERE EMAIL = ?";

        // connect to database
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            // get the result
            ResultSet resultSet = statement.executeQuery();

            // set user attributes
            if (resultSet.next()) {
                user.setId(resultSet.getInt("ID"));
                user.setFirstName(resultSet.getString("FIRSTNAME"));
                user.setLastName(resultSet.getString("LASTNAME"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setPassword(resultSet.getString("PASS"));
                user.setActive(resultSet.getBoolean("ISACTIVE"));
                user.setCreatedAt(resultSet.getTimestamp("CREATEDAT"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null; // If exception thrown
        }
        return user; // return user
    }



    // Delete User by ID
    public boolean deleteUserById(int id) {
        // The executed sql statement
        String sql = "DELETE FROM SYS_USER WHERE ID = " + id;

        // connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            // the affected number of rows (1 if true & 0 if false)
            return statement.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // default return (if exception thrown)
    }

    // Update User by ID Param: (ID of user, the new object of user)
    public boolean updateUserById(int id, User newUser) {

        // The executed sql statement
        String sql = "UPDATE SYS_USER " +
                "SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PASS = ?, ISACTIVE = ?, CREATEDAT = ? " +
                "WHERE ID = ?";

        // connect to database
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // insert the values in the executed sql statement
            pstmt.setString(1, newUser.getFirstName());
            pstmt.setString(2, newUser.getLastName());
            pstmt.setString(3, newUser.getEmail());
            pstmt.setString(4, newUser.getPassword());
            pstmt.setBoolean(5, newUser.isActive());
            pstmt.setTimestamp(6, newUser.getCreatedAt());
            pstmt.setInt(7, id);

            // the affected number of rows (1 if true & 0 if false)
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  // default return (if exception thrown)
    }



    /*
     * Retrieve all Users
     * This is a Generic function
     * to retrieve all users with type (Admin & Lawyer & LawyerAssist)
     * according to the given (object) parameter
     * */
    public List<User> findAll() {
        // List to store all the retrieved objects (User)
        List<User> users = new ArrayList<>();
        // The executed query
        String sql = "select * from SYS_USER";

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement()) {

            // Get the result (rows)
            ResultSet resultSet = statement.executeQuery(sql);
            // Set user attributes for each user
            while (resultSet.next()) { // for each row
                User user = new Admin();
                user.setId(resultSet.getInt("ID"));
                user.setFirstName(resultSet.getString("FIRSTNAME"));
                user.setLastName(resultSet.getString("LASTNAME"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setPassword(resultSet.getString("PASS"));
                user.setActive(resultSet.getBoolean("ISACTIVE"));
                user.setCreatedAt(resultSet.getTimestamp("CREATEDAT"));
                users.add(user); // add the retrieved user
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null; // if exception thrown
        }
        return users;
    }
}