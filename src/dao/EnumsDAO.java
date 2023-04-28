package dao;

import entity.CaseCategory;
import entity.CaseState;
import entity.Complexity;
import entity.LawType;

import java.sql.*;

/*
* Warning!!!!
* This class is made only to insert enums tables data
* Please DO NOT run this file
*/
public class EnumsDAO {
    public static void main(String[] args) {

        final String url = "jdbc:derby:Database/LAWFIRMDB;";


//         Insert data sql statement
        String sql = "";

        sql = "INSERT INTO CASECATEGORY (CASETYPE)" +
                " VALUES (?)";

        // Connect to Database
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            int i = 1;
            for (CaseCategory c: CaseCategory.values()) {
                // Add the variable
                pstmt.setString(1, c.toString());
                System.out.println("CaseCategory added? " + (pstmt.executeUpdate() > 0));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


         sql = "INSERT INTO CASESTATE (CASETYPE)" +
                "VALUES (?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            for (CaseState c: CaseState.values()) {
                // Add the variable
                pstmt.setString(1, c.toString());
                System.out.println("CaseSate added? " + (pstmt.executeUpdate() > 0));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




         sql = "INSERT INTO COMPLEXITY (CLEVEL)" +
                "VALUES (?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            for (Complexity c: Complexity.values()) {
                // Add the variable
                pstmt.setString(1, c.toString());
                System.out.println("Complexity added? " + (pstmt.executeUpdate() > 0));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


         sql = "INSERT INTO LAWTYPE (LAWYERTYPE)" +
                "VALUES (?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            for (LawType lawType: LawType.values()) {
                // Add the variable
                pstmt.setString(1, lawType.toString());
                System.out.println("LawyerAdded added? " + (pstmt.executeUpdate() > 0));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
