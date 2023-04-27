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

    public boolean save(User user) {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // insert some data into the table
            String sql = "INSERT INTO SYS_USER (firstname, lastname, email, pass, isactive)" +
                    " VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setBoolean(5, user.isActive());
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

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

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

           String sql = "SELECT * FROM SYS_USER WHERE ID = " + id;
           ResultSet resultSet = statement.executeQuery(sql);

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
        }
        return user;
    }
    public boolean deleteUserById(int id) {
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM SYS_USER WHERE ID = " + id;
            return statement.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateUserById(int id, User newUser) {

        String sql = "UPDATE SYS_USER " +
                "SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PASS = ?, ISACTIVE = ?, CREATEDAT = ? " +
                "WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, newUser.getFirstName());
            pstmt.setString(2, newUser.getLastName());
            pstmt.setString(3, newUser.getEmail());
            pstmt.setString(4, newUser.getPassword());
            pstmt.setBoolean(5, newUser.isActive());
            pstmt.setTimestamp(6, newUser.getCreatedAt());
            pstmt.setInt(7, id);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public <T> List<User> findAll(T object) {
        List<User> users = new ArrayList<>();
        String sql = "select * from SYS_USER";

        // Get the type of user to find
        User user = null;
        if (object instanceof Admin) {
            user = new Admin();
        } else if (object instanceof Lawyer) {
            user = new Lawyer();
        } else if (object instanceof LawyerAssistant) {
            user = new LawyerAssistant();
        }

        try (Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user.setId(resultSet.getInt("ID"));
                user.setFirstName(resultSet.getString("FIRSTNAME"));
                user.setLastName(resultSet.getString("LASTNAME"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setPassword(resultSet.getString("PASS"));
                user.setActive(resultSet.getBoolean("ISACTIVE"));
                user.setCreatedAt(resultSet.getTimestamp("CREATEDAT"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}