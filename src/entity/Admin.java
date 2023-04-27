package entity;

import java.time.LocalDateTime;

public class Admin extends User {
private boolean isGlobal;

    public Admin(String firstName, String lastName, String email,String password,  String phoneNo, boolean isActive, boolean isGlobal) {
        super(firstName, lastName, email, phoneNo, password, isActive);
        this.isGlobal = isGlobal;
    }

    public boolean isGlobal() {
        return isGlobal;
    }

    public void setGlobal(boolean global) {
        isGlobal = global;
    }
}
