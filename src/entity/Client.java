package entity;

import java.util.Comparator;
import java.util.Objects;

public class Client implements Comparable<Client>, Comparator<Client> {
    private int ClientID;
    private String firstName;
    private String lastName;
    private String phoneNo;

    public Client(String firstName, String lastName, String phoneNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
    }
    public Client(){}

    public int getClientID() {
        return ClientID;
    }

    public void setClientID(int clientID) {
        ClientID = clientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public int compareTo(Client obj) {
        return Integer.compare(this.getClientID(), obj.getClientID());
    }

    @Override
    public int compare(Client o1, Client o2) {
        return Integer.compare(o1.getClientID(), o2.getClientID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return ClientID == client.ClientID && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(phoneNo, client.phoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ClientID);
    }

    @Override
    public String toString() {
        return "Client{" +
                "ClientID=" + ClientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
