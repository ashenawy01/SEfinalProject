import dao.UserDAO;
import entity.Admin;
import entity.User;

public class newMain {
    public static void main(String[] args) {
        User user = new Admin("Abdelrhman", "Elshenawy", "aa@aa.com", "test123", "01122", true, true);
        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
    }
}
