package service;

import dao.LawyerAssistDAO;
import dao.UserDAO;
import entity.Lawyer;
import entity.LawyerAssistant;
import entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LawyerAssistService {


    private final static LawyerAssistDAO lawyerAssistDAO = new LawyerAssistDAO();
    private static final UserDAO userDAO = new UserDAO();




    // Create new user no mater his type is
    public boolean createLawyerAssistant (LawyerAssistant lawyerAssist) {
        // the return variables
        boolean isUserSaved = false, isLawyerAssistantSaved = false;

        isUserSaved =  userDAO.save(lawyerAssist); // save in User table
        // get the saved user from db to get its assigned ID
        LawyerAssistant lawyerAssistTemp = (LawyerAssistant) userDAO.findUserByEmail(lawyerAssist, lawyerAssist.getEmail());

        lawyerAssist.setId(lawyerAssistTemp.getId()); // set user ID to LawyerAssistant
        isLawyerAssistantSaved = lawyerAssistDAO.save(lawyerAssist); // save in LawyerAssistant table

        return isLawyerAssistantSaved && isUserSaved; // saved in User Table & LawyerAssistant table
    }



    // Update LawyerAssistant info
    // Note : the parameter (lawyerAssist) include the new user data but the same ID
    public boolean updateLawyerAssistant (LawyerAssistant lawyerAssist) {
        // the return variables
        boolean isUserUpdated = false, isLawyerAssistantUpdated = false;
        // update in User table
        isUserUpdated =  userDAO.updateUserById(lawyerAssist.getId(), lawyerAssist);
        // update in LawyerAssistant Table
        isLawyerAssistantUpdated = lawyerAssistDAO.updateLawyerAssistById(lawyerAssist.getId(), lawyerAssist);
        return isUserUpdated && isLawyerAssistantUpdated; // updated in User Table & LawyerAssistant table
    }

    // Find lawyerAssist by his email
    public LawyerAssistant findLawyerAssistantByEmail (String email) {
        LawyerAssistant userTemp = new LawyerAssistant();
        userTemp = (LawyerAssistant) userDAO.findUserByEmail(userTemp, email);  // get LawyerAssistant data in User Table
        LawyerAssistant finalLawyerAssistant = lawyerAssistDAO.findById(userTemp.getId());  // get LawyerAssistant data in LawyerAssistant Table
        // add the attributes from user table
        finalLawyerAssistant.setFirstName(userTemp.getFirstName());
        finalLawyerAssistant.setLastName(userTemp.getLastName());
        finalLawyerAssistant.setEmail(userTemp.getEmail());
        finalLawyerAssistant.setPassword(userTemp.getPassword());
        finalLawyerAssistant.setActive(userTemp.isActive());
        return finalLawyerAssistant;
    }

    // find LawyerAssistant by ID (All lawyerAssist data)
    public LawyerAssistant findLawyerAssistantByID (int id) {
        LawyerAssistant userTemp = new LawyerAssistant();
        userTemp = (LawyerAssistant) userDAO.findUserById(userTemp, id);  // get LawyerAssistant data in User Table
        LawyerAssistant finalLawyerAssistant = lawyerAssistDAO.findById(userTemp.getId());  // get LawyerAssistant data in LawyerAssistant Table
        // add the attributes from user table
        if (finalLawyerAssistant == null) {
            return null;
        }
        finalLawyerAssistant.setFirstName(userTemp.getFirstName());
        finalLawyerAssistant.setLastName(userTemp.getLastName());
        finalLawyerAssistant.setEmail(userTemp.getEmail());
        finalLawyerAssistant.setPassword(userTemp.getPassword());
        finalLawyerAssistant.setActive(userTemp.isActive());
        return finalLawyerAssistant;
    }
    public List<LawyerAssistant> findAllLawyerAssistants() {
        Map<Integer, User> userMap = new HashMap<>();
        LawyerAssistant lawyerAssistObj = new LawyerAssistant();
        List<User> users = userDAO.findAll();
        for (User user : users) {
            userMap.put(user.getId(), user);
        }

        List<LawyerAssistant> lawyerAssists = lawyerAssistDAO.findAll();

        for (LawyerAssistant lawyerAssist : lawyerAssists) {
            User user = userMap.get(lawyerAssist.getId());
            if (user != null) {
                lawyerAssist.setFirstName(user.getFirstName());
                lawyerAssist.setLastName(user.getLastName());
                lawyerAssist.setEmail(user.getEmail());
                lawyerAssist.setPassword(user.getPassword());
                lawyerAssist.setActive(user.isActive());
            }
        }
        return lawyerAssists;
    }

    public boolean deleteLawyerAssistantById(int id) {
        if (findLawyerAssistantByID(id) == null) {
            return false;
        }
        return  lawyerAssistDAO.deleteLawyerAssistById(id) && userDAO.deleteUserById(id);
    }

}
