import dao.UserDAO;
import entity.Admin;
import entity.User;

public class newMain {
    public static void main(String[] args) {
//        User user = new Admin("Abdelrhman", "Elshenawy", "aa@aa.com", "test123", "01122", true, true);
        UserDAO userDAO = new UserDAO();
////        userDAO.save(user);
        User admin = new Admin();
//
//        admin = (Admin) userDAO.findUserById(admin, 101);
//        System.out.println(admin.getFirstName() + " " + admin.getLastName());
//
//        admin.setPassword("test123");
//        admin.setLastName("El-Shenawy");
//        System.out.println(userDAO.updateUserById(101, admin));
//
//        admin = (Admin) userDAO.findUserById(admin, 101);
//        System.out.println(admin.getFirstName() + " " + admin.getLastName());
//        System.out.println(userDAO.deleteUserById(401));


        System.out.println(userDAO.findAll(admin));




    }
}
