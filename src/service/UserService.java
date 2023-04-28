package service;

import dao.*;
import entity.Admin;
import entity.Lawyer;
import entity.LawyerAssistant;
import entity.User;

public class UserService {
    private static final UserDAO userDAO = new UserDAO();
    private final static LawyerDAO lawyerDAO = new LawyerDAO();
    private final static AdminADO adminDAO = new AdminADO();
    private final static LawyerAssistDAO lawyerAssistDAO = new LawyerAssistDAO();


    // Create a new user no mater his type is
    public boolean save (Object object) {
        // the return variables
        boolean savedUser = false, savedType = false;
        String email = ""; // user new email

        User user = null;
        // check the coming user
        if (object instanceof User) {
            // saving in USER table
            user = (User) object;
            savedUser =  userDAO.save(user);
        } else { // Object is not User
            return false;
        }
        if (user != null) {
            // Get the type of user to find
            if (object instanceof Admin admin) {
                // get the saved user from db to get its assigned ID
                user = userDAO.findUserByEmail(admin, user.getEmail());
                Admin newAdmin = (Admin) object; // New Admin to save
                newAdmin.setId(user.getId()); // set the admin id
                savedType = adminDAO.save(newAdmin); // save the new admin
            } else if (object instanceof Lawyer) {
                Lawyer lawyer = (Lawyer) object;
                savedType = lawyerDAO.save(lawyer);
            } else if (object instanceof LawyerAssistant) {
                LawyerAssistant lawyerAssistant = (LawyerAssistant) object;
                savedType = LawyerAssistDAO.save(lawyerAssistant);
            } else { // unknown object
                return false;
            }
        }

        return savedUser && savedType; // saved in User Table & the user type table
    }

    public User findUserByEmail (Object object, String email) {
        if (object instanceof Admin admin) {
            return userDAO.findUserByEmail(admin, email);
        } else if (object instanceof Lawyer lawyer) {
            return userDAO.findUserByEmail(lawyer, email);
        } else if (object instanceof LawyerAssistant lawyerAssistant) {
            return userDAO.findUserByEmail(lawyerAssistant, email);
        } else { // unknown object
            return null;
        }
    }




}
