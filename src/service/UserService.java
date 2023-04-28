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


    // Create new user no mater his type is
    public boolean createUser (Object object) {
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
                Admin newAdmin = (Admin) object;
                newAdmin.setId(user.getId());
                savedType = adminDAO.save(newAdmin);
            } else if (object instanceof Lawyer lawyer) {
                // get the saved user from db to get its assigned ID
                user = userDAO.findUserByEmail(lawyer, user.getEmail());
                Lawyer newLawyer = (Lawyer) object;
                newLawyer.setId(user.getId());
                savedType = lawyerDAO.save(newLawyer);
            } else if (object instanceof LawyerAssistant lawyerAssistant) {
                // get the saved user from db to get its assigned ID
                user = userDAO.findUserByEmail(lawyerAssistant, user.getEmail());
                LawyerAssistant newLawyerAssist = (LawyerAssistant) object;
                newLawyerAssist.setId(user.getId());
                savedType = LawyerAssistDAO.save(newLawyerAssist);
            } else { // unknown object
                return false;
            }
        }

        return savedUser && savedType; // saved in User Table & the user type table
    }

    // Find any uer by his email
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

    // Update any user info
    // Note : the parameter (userObj) include the new user data but the same ID
    public boolean updateUser (Object userObj) {
        // the return variables
        boolean savedUser = false, savedType = false;

        User user = null;
        // check the coming user
        if (userObj instanceof User) {
            // saving in USER table
            user = (User) userObj;
            savedUser =  userDAO.updateUserById(user.getId(), user); // update in user table
        } else { // Object is not User
            return false;
        }

        if (user != null) { // user is updated
            // Get the type of user to find
            if (userObj instanceof Admin admin) { // userObj is Admin
                Admin newAdmin = (Admin) userObj;
                // update in Admin table
                savedType = adminDAO.updateAdminById(newAdmin.getId(), newAdmin);
            } else if (userObj instanceof Lawyer lawyer) { // userObj is Lawyer
                Lawyer newLawyer = (Lawyer) userObj;
                // update in Lawyer table
                savedType = lawyerDAO.updateLawyerById(newLawyer.getId(), newLawyer);
            } else if (userObj instanceof LawyerAssistant lawyerAssistant) { // userObj is LawyerAssistant
                LawyerAssistant newLawyerAssist = (LawyerAssistant) userObj;
                // update in LawyerAssistant table
                savedType = lawyerAssistDAO.updateLawyerAssistById(newLawyerAssist.getId(), newLawyerAssist);
            } else { // unknown object
                return false;
            }
        }

        return savedUser && savedType; // saved in User Table & the user type table
    }

}
