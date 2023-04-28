package service;

import dao.AdminADO;
import dao.UserDAO;
import entity.Admin;
import entity.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminService {
    private static final UserDAO userDAO = new UserDAO();
    private final static AdminADO adminDAO = new AdminADO();


    // Create new user no mater his type is
    public boolean createAdmin (Admin admin) {
        // the return variables
        boolean savedUser = false, savedAdmin = false;

        User user = admin;
        savedUser =  userDAO.save(user); // save in User table

        // get the saved user from db to get its assigned ID
        user = userDAO.findUserByEmail(admin, user.getEmail());

        Admin newAdmin = (Admin) admin;
        newAdmin.setId(user.getId()); // set user ID to Admin
        savedAdmin = adminDAO.save(newAdmin); // save in Admin table

        return savedUser && savedAdmin; // saved in User Table & Admin table
    }

    // Find admin by his email
    public Admin findAdminByEmail (String email) {
        Admin finslAdmin = new Admin();
        finslAdmin = (Admin) userDAO.findUserByEmail(finslAdmin, email);
        Admin currentAdmin = adminDAO.findAdminById(finslAdmin.getId());  // get Admin data in Admin Table
        finslAdmin.setGlobal(currentAdmin.isGlobal()); // add admin data
        return finslAdmin;
    }

    // Update Admin info
    // Note : the parameter (admin) include the new user data but the same ID
    public boolean updateAdmin (Admin admin) {
        // the return variables
        boolean isUserUpdated = false, isAdminUpdated = false;
        // update in User table
        isUserUpdated =  userDAO.updateUserById(admin.getId(), admin);
        // update in Admin Table
        isAdminUpdated = adminDAO.updateAdminById(admin.getId(), admin);
        return isUserUpdated && isAdminUpdated; // updated in User Table & Admin table
    }

    // find Admin by ID (All admin data)
    public Admin findAdminByID (int id) {
        Admin admin = new Admin();
        admin = (Admin) userDAO.findUserById(admin, id);// get Admin data in User Table
        Admin currentAdmin = adminDAO.findAdminById(id);  // get Admin data in Admin Table
        admin.setGlobal(currentAdmin.isGlobal()); // add admin data
        return admin;
    }
    public List<Admin> findAllAdmins() {
        Map<Integer, User> userMap = new HashMap<>();
        Admin adminObj = new Admin();
        List<User> users = userDAO.findAll();
        for (User user : users) {
            userMap.put(user.getId(), user);
        }

        List<Admin> admins = adminDAO.findAll();
        for (Admin admin : admins) {
            User user = userMap.get(admin.getId());
            admin.setFirstName(user.getFirstName());
            admin.setLastName(user.getLastName());
            admin.setEmail(user.getEmail());
            admin.setPassword(user.getPassword());
            admin.setActive(user.isActive());
        }
        return admins;
    }

    public boolean deleteAdminById(int id) {
        if (findAdminByID(id) == null) {
            return false;
        }
        return  adminDAO.deleteAdminById(id) && userDAO.deleteUserById(id);
    }


}
