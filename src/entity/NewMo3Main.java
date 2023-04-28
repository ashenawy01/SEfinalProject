package entity;
import dao.ClientDAO_OLD;
public class NewMo3Main {
    public static void main(String[] args) {
        Client client = new Client("Mo", "Mohamed", "0115");
        ClientDAO_OLD clientDAOOLD = new ClientDAO_OLD();
        clientDAOOLD.save(client);
    }
}
