package dao;

import entity.Bill;
import entity.Complexity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {
        private final String url = "jdbc:derby:Database/LAWFIRMDB;";

        // Save Bill attributes in table client
        public boolean save(Bill bill) {

        // Insert data sql statement
        String sql = "INSERT INTO BILL ( caseId, takenDays, travelFee, complexity, expertFee, adminCost) VALUES(?,?,?,?,?,?)";


        // Connect to Database
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Add the variable from the input object to the table
            pstmt.setInt(1, bill.getCaseID());
            pstmt.setInt(2, bill.getTakenDays());
            pstmt.setDouble(3, bill.getTravelFee());
            pstmt.setInt(4, bill.getComplexity().ordinal() + 1);
            pstmt.setDouble(5, bill.getExpertFee());
            pstmt.setDouble(6, bill.getAdminCost());

            // the number of inserted rows (i) if true & (0) if false
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; //default return (if exception thrown)
    }


        // Delete bill by it's ID
        public boolean deleteBillById(int id) {
        // The executed query
        String sql = "DELETE FROM BILL WHERE ID = " + id;

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


        // Update Bill by ID Parm(bill id , the new object of bill)
        public boolean updateBillById(int id, Bill newBill) {

        // The executed query (Note id cannot be updated)
        String sql = "UPDATE BILL set CASEID = ?, TAKENDAYS = ?, TRAVELFEE = ?, COMPLEXITY = ?, EXPERTFEE = ?, ADMINCOST = ? WHERE ID = " + id;

        // Connect to Database
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // add the new variable from the input object
            pstmt.setInt(1, newBill.getCaseID());
            pstmt.setInt(2, newBill.getTakenDays());
            pstmt.setDouble(3, newBill.getTravelFee());
            pstmt.setInt(4, newBill.getComplexity().ordinal() + 1);
            pstmt.setDouble(5, newBill.getExpertFee());
            pstmt.setDouble(6, newBill.getAdminCost());

            // the affected number of raws (if > 0 the row is updated)
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  //default return (if exception thrown)
    }


        // Retrieve all bills
        public List<Bill> findAll() {
        // List to store all the retrieved objects (bills)
        List<Bill> bills = new ArrayList<>();
        // The executed query
        String sql = "select * from BILL";

        Complexity[] complexities = Complexity.values();
        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {


            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // for each row (client)
                Bill bill = new Bill();
                bill.setBillID(resultSet.getInt("ID"));
                bill.setCaseID(resultSet.getInt("CaseID"));
                bill.setTakenDays(resultSet.getInt("TAKENDAYS"));
                bill.setTravelFee(resultSet.getDouble("TRAVELFEE"));
                bill.setComplexity(complexities[resultSet.getInt("COMPLEXITY")]);
                bill.setExpertFee(resultSet.getDouble("EXPERTFEE"));
                bill.setAdminCost((resultSet.getDouble("ADMINCOST")));
                bills.add(bill); // Add bill to the list
            }
            return bills; // return the retrieved list

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }


        // Retrieve bill by ID
        public Bill findById(int id) {
        // The executed query
        String sql = "select * from BILL where ID = " + id;
        // bill to present each retrieved client
        Bill bill = new Bill();
        Complexity [] complexities = Complexity.values();

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // Get all rows
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) { // for each row (client)
                bill.setBillID(resultSet.getInt("ID"));
                bill.setCaseID(resultSet.getInt("CaseID"));
                bill.setTakenDays(resultSet.getInt("TAKENDAYS"));
                bill.setTravelFee(resultSet.getDouble("TRAVELFEE"));
                bill.setComplexity(complexities[resultSet.getInt("COMPLEXITY")]);
                bill.setExpertFee(resultSet.getDouble("EXPERTFEE"));
                bill.setAdminCost((resultSet.getDouble("ADMINCOST")));
            }
            return bill; // return the retrieved client
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  //default return (if exception thrown)
    }
}
