package entity;
import dao.ClientDAO;
public class NewMo3Main {
    public static void main(String[] args) {
        Client client = new Client("Mo", "Mohamed", "0115");
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.save(client);
    }
}
