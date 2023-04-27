import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:derby:Database/LAWFIRMDB;";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // create a new table
            String sql = "CREATE TABLE mytable (id INT PRIMARY KEY, name VARCHAR(255))";
            stmt.executeUpdate(sql);

            // insert some data into the table
            sql = "INSERT INTO mytable (id, name) VALUES (1, 'John'), (2, 'Jane')";
            stmt.executeUpdate(sql);

            // retrieve data from the table
            sql = "SELECT * FROM mytable";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id: " + id + ", name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}