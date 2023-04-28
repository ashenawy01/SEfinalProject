import dao.AdminADO;
import dao.LawyerDAO;
import dao.UserDAO;
import entity.*;

public class newMain {



    final static UserDAO userDAO = new UserDAO();
    final static LawyerDAO lawyerDAO = new LawyerDAO();
    final static AdminADO adminDAO = new AdminADO();
    public static void main(String[] args) {


//        // Testing UserDAO
//        // All functions are tested (all done)
//        User user = new Admin("Abdelrhman", "Elshenawy", "aa@aa.com", "test123", "01122", true, true);
////        userDAO.save(user);
//        User admin = new Admin();
////
//        admin = (Admin) userDAO.findUserById(admin, 1);
//        System.out.println(admin.getFirstName() + " " + admin.getLastName());
//
////        admin.setPassword("test123");
////        admin.setLastName("El-Shenawy");
////        System.out.println(userDAO.updateUserById(101, admin));
////
////        admin = (Admin) userDAO.findUserById(admin, 101);
////        System.out.println(admin.getFirstName() + " " + admin.getLastName());
////        System.out.println(userDAO.deleteUserById(401));
//
//
//        System.out.println(userDAO.findAll(admin));
//
//        // Testing AdminDAO
//        // All functions are tested (all done)
//        Admin admin = new Admin();
//        admin = (Admin) userDAO.findUserById(admin, 1);
//        admin.setGlobal(true);
//        System.out.println("Lawyer saved ? " + adminDAO.save(admin));
//        System.out.println("Get all Admins ....");
//        System.out.println(adminDAO.findAll());
//        System.out.println("Update the global status....");
//        admin.setGlobal(false);
//        System.out.println("Admin updated ? " + adminDAO.updateAdminById(1, admin));
//        System.out.println("Get all Admins ....");
//        System.out.println(adminDAO.findAll());
//        System.out.println("Delete the admin ... ");
////        System.out.println("Admin deleted ? " + adminDAO.deleteAdminById(1));
//        System.out.println("Get all Admins ....");
//        System.out.println(adminDAO.findAll());
//
//
//        // Testing Lawyer
//        // All functions are tested (all done)
//        Lawyer lawyer = new Lawyer();
//        lawyer = (Lawyer) userDAO.findUserById(lawyer, 1);
//        lawyer.setExperienceYear(5);
//        lawyer.setType(LawType.Corporate);
//        lawyer.setSenior(true);
//        lawyer.setAvialable(false);
//        System.out.println("Lawyer saved ? " + lawyerDAO.save(lawyer));
//        System.out.println("Get find the saved Lawyer ....");
//        System.out.println(lawyerDAO.findById(1));
//        System.out.println("Update the availability status....");
//        lawyer.setAvialable(true);
//        System.out.println("Lawyer updated ? " + lawyerDAO.updateLawyerById(1, lawyer));
//        System.out.println("Get all Lawyers ....");
//        System.out.println(lawyerDAO.findAll());
//        System.out.println("Delete the lawyer ... ");
////        System.out.println("Lawyer deleted ? " + lawyerDAO.deleteLawyerById(1));
//        System.out.println("Get all Lawyers ....");
//        System.out.println(lawyerDAO.findAll());
        

    }
}
