import entity.Admin;
import entity.LawType;
import entity.Lawyer;
import entity.User;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Admin admin =  new Admin("Abdelrhman", "Elshenawy", "aa@aa.com", "test123", "01122", true, true);
        Lawyer lawyer =  new Lawyer("Abdelrhman", "Elshenawy", "aa@aa.com", "test123", "01122", true, 5, LawType.Corporate, true);

        admin.setGlobal(false);
        User user = lawyer;
        Lawyer newLawyer = (Lawyer) user;
        System.out.println(newLawyer.getExperienceYear());

    }
}