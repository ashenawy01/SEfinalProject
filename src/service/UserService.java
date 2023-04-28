package service;

import dao.*;
import entity.*;

import java.util.List;

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

    User findUserByID (Object object, int id) {
        // Get the type of user to find
        User user = null;
        if (object instanceof Admin admin) {
            user = userDAO.findUserById(admin, id); // get Admin data in User Table
            Admin currentAdmin = adminDAO.findAdminById(id);  // get Admin data in User Table
            // add the joined table data (User & Admin)
            Admin finalAdmin = (Admin) user;
            finalAdmin.setGlobal(currentAdmin.isGlobal());
            return finalAdmin; // Final result
        } else if (object instanceof Lawyer lawyer) {
            user = userDAO.findUserById(lawyer, id); // get Lawyer data in User Table
            Lawyer currentLawyer = lawyerDAO.findById(id);  // get Lawyer data in Lawyer Table
            // add the joined table data (User & Lawyer)
            Lawyer finalLawyer = (Lawyer) user;
            finalLawyer.setAvialable(currentLawyer.isAvialable());
            finalLawyer.setType(currentLawyer.getType());
            finalLawyer.setExperienceYear(currentLawyer.getExperienceYear());
            finalLawyer.setSenior(currentLawyer.isSenior());
            return finalLawyer; // Final result
        } else if (object instanceof LawyerAssistant lawyerAssistant) {
            user = userDAO.findUserById(lawyerAssistant, id); // get LawyerAssistant data in User Table
            LawyerAssistant currentLawAssist = lawyerAssistDAO.findById(id);  // get LawyerAssistant data in LawyerAssistant Table
            // add the joined table data (User & LawyerAssistant)
            LawyerAssistant finalLawyerAssistant = (LawyerAssistant) user;
            finalLawyerAssistant.setSuperVisor(currentLawAssist.isSuperVisor());
            return finalLawyerAssistant; // Final result
        } else {
            return null;
        }
    }

}
