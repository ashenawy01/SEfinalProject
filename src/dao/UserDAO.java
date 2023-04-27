package dao;

import entity.Lawyer;
import entity.User;

import java.sql.*;

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

}