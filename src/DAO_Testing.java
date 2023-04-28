import dao.*;

public class DAO_Testing {



    final static UserDAO userDAO = new UserDAO();
    final static LawyerDAO lawyerDAO = new LawyerDAO();
    final static AdminADO adminDAO = new AdminADO();
    final static CaseDAO caseDAO = new CaseDAO();
    final static ClientDAO clientDAO = new ClientDAO();
    final static LawyerAssistDAO lawyerAssistDAO = new LawyerAssistDAO();
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


//        // Testing LawyerAssistant
//        // All functions are tested (all done)
//        LawyerAssistant lawyerAssist = new LawyerAssistant();
//        lawyerAssist = (LawyerAssistant) userDAO.findUserById(lawyerAssist, 1);
//        lawyerAssist.setSuperVisor(false);
//        System.out.println("LawyerAssistant saved ? " + lawyerAssistDAO.save(lawyerAssist));
//        System.out.println("Get find the saved LawyerAssistant ....");
//        System.out.println(lawyerAssistDAO.findById(1));
//        System.out.println("Update the availability status....");
//        lawyerAssist.setSuperVisor(true);
//        System.out.println("LawyerAssistant updated ? " + lawyerAssistDAO.updateLawyerAssistById(1, lawyerAssist));
//        System.out.println("Get all LawyerAssistants ....");
//        System.out.println(lawyerAssistDAO.findAll());
//        System.out.println("Delete the lawyerAssist ... ");
////        System.out.println("LawyerAssistant deleted ? " + lawyerAssistDAO.deleteLawyerAssistById(1));
//        System.out.println("Get all LawyerAssistants ....");
//        System.out.println(lawyerAssistDAO.findAll());
//

//
//        // Testing ClientDAO
//        // All functions are tested (all done)
//        Client newClient = new Client("Abdelrhman", "Ali", "151515");
//        System.out.println("Client saved ? " + clientDAO.save(newClient));
//        System.out.println("Get find the saved Client ....");
//        System.out.println(clientDAO.findById(201));
//        System.out.println("Update the Last name....");
//        newClient.setLastName("El-Shenawy");
//        System.out.println("Client updated ? " + clientDAO.updateClientById(201, newClient));
//        System.out.println("Get all Clients ....");
//        System.out.println(clientDAO.findAll());
//        System.out.println("Delete the newClient ... ");
//        System.out.println("Case deleted ? " + clientDAO.deleteClientById(201));
//        System.out.println("Get all Clients ....");
//        System.out.println(clientDAO.findAll());
//


//        // Testing CaseDAO
//        // All functions are tested (all done)
//        Case newCase = new Case("BUE case", "Case was issued by a group of BUE students due to the large amount of tasks that they get",
//                null, null, CaseCategory.Civil_Case, CaseState.Active, 1);
//        System.out.println("Case saved ? " + caseDAO.save(newCase));
//        System.out.println("Get find the saved Case ....");
//        System.out.println(caseDAO.findById(401));
//        System.out.println("Update the availability status....");
//        newCase.setName("BUE students case");
//        System.out.println("Case updated ? " + caseDAO.updateCaseById(401, newCase));
//        System.out.println("Get all Cases ....");
//        System.out.println(caseDAO.findAll());
//        System.out.println("Delete the newCase ... ");
////        System.out.println("Case deleted ? " + caseDAO.deleteCaseById(401));
//        System.out.println("Get all Cases ....");
//        System.out.println(caseDAO.findAll());
//

    }
}
