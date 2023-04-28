package entity;

import java.time.LocalDateTime;

public class Lawyer extends User{
    private int experienceYear;
    private LawType type;
    private boolean isSenior;
    private boolean isAvialable;

    public Lawyer(String firstName, String lastName, String email, String phoneNo, String password, boolean isActive, int experienceYear, LawType type, boolean isSenior) {
        super(firstName, lastName, email, phoneNo, password, isActive);
        this.experienceYear = experienceYear;
        this.type = type;
        this.isSenior = isSenior;
    }

    public Lawyer () {}
    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public LawType getType() {
        return type;
    }

    public void setType(LawType type) {
        this.type = type;
    }

    public boolean isSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        isSenior = senior;
    }

    public boolean isAvialable() {
        return isAvialable;
    }

    public void setAvialable(boolean avialable) {
        isAvialable = avialable;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "experienceYear=" + experienceYear +
                ", type=" + type +
                ", isSenior=" + isSenior +
                ", isAvialable=" + isAvialable +
                '}';
    }
}
