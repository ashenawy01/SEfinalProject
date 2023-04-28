package service;

import dao.LawyerDAO;
import dao.UserDAO;
import entity.Lawyer;
import entity.Lawyer;
import entity.Lawyer;
import entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LawyerService {

    private static final UserDAO userDAO = new UserDAO();
    private final static LawyerDAO lawyerDAO = new LawyerDAO();

    // Create new user no mater his type is
    public boolean createLawyer (Lawyer lawyer) {
        // the return variables
        boolean isUserSaved = false, isLawyerSaved = false;

        isUserSaved =  userDAO.save(lawyer); // save in User table
        // get the saved user from db to get its assigned ID
        Lawyer lawyerTemp = (Lawyer) userDAO.findUserByEmail(lawyer, lawyer.getEmail());

        lawyer.setId(lawyerTemp.getId()); // set user ID to Lawyer
        isLawyerSaved = lawyerDAO.save(lawyer); // save in Lawyer table

        return isLawyerSaved && isUserSaved; // saved in User Table & Lawyer table
    }



    // Update Lawyer info
    // Note : the parameter (lawyer) include the new user data but the same ID
    public boolean updateLawyer (Lawyer lawyer) {
        // the return variables
        boolean isUserUpdated = false, isLawyerUpdated = false;
        // update in User table
        isUserUpdated =  userDAO.updateUserById(lawyer.getId(), lawyer);
        // update in Lawyer Table
        isLawyerUpdated = lawyerDAO.updateLawyerById(lawyer.getId(), lawyer);
        return isUserUpdated && isLawyerUpdated; // updated in User Table & Lawyer table
    }

    // Find lawyer by his email
    public Lawyer findLawyerByEmail (String email) {
        Lawyer userTemp = new Lawyer();
        userTemp = (Lawyer) userDAO.findUserByEmail(userTemp, email);  // get Lawyer data in User Table
        Lawyer finalLawyer = lawyerDAO.findById(userTemp.getId());  // get Lawyer data in Lawyer Table
        // add the attributes from user table
        finalLawyer.setFirstName(userTemp.getFirstName());
        finalLawyer.setLastName(userTemp.getLastName());
        finalLawyer.setEmail(userTemp.getEmail());
        finalLawyer.setPassword(userTemp.getPassword());
        finalLawyer.setActive(userTemp.isActive());
        return finalLawyer;
    }

    // find Lawyer by ID (All lawyer data)
    public Lawyer findLawyerByID (int id) {
        Lawyer userTemp = new Lawyer();
        userTemp = (Lawyer) userDAO.findUserById(userTemp, id);  // get Lawyer data in User Table
        Lawyer finalLawyer = lawyerDAO.findById(userTemp.getId());  // get Lawyer data in Lawyer Table
        // add the attributes from user table
        if (finalLawyer == null) {
            return null;
        }
        finalLawyer.setFirstName(userTemp.getFirstName());
        finalLawyer.setLastName(userTemp.getLastName());
        finalLawyer.setEmail(userTemp.getEmail());
        finalLawyer.setPassword(userTemp.getPassword());
        finalLawyer.setActive(userTemp.isActive());
        return finalLawyer;
    }
    public List<Lawyer> findAllLawyers() {
        Map<Integer, User> userMap = new HashMap<>();
        Lawyer lawyerObj = new Lawyer();
        List<User> users = userDAO.findAll();
        for (User user : users) {
            userMap.put(user.getId(), user);
        }

        List<Lawyer> lawyers = lawyerDAO.findAll();
        for (Lawyer lawyer : lawyers) {
            User user = userMap.get(lawyer.getId());
            lawyer.setFirstName(user.getFirstName());
            lawyer.setLastName(user.getLastName());
            lawyer.setEmail(user.getEmail());
            lawyer.setPassword(user.getPassword());
            lawyer.setActive(user.isActive());
        }
        return lawyers;
    }

    public boolean deleteLawyerById(int id) {
        if (findLawyerByID(id) == null) {
            return false;
        }
        return  lawyerDAO.deleteLawyerById(id) && userDAO.deleteUserById(id);
    }

}
