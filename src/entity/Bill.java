package entity;

public class Bill {
    private int billID;
    private int caseID;
    private int takenDays;
    private double courtFee;
    private double travelFee;
    private Complexity complexity;
    private double expertFee;
    private double adminCost;

    public Bill(int caseID, int takenDays, double courtFee, double travelFee, Complexity complexity, double expertFee, double adminCost) {
        this.caseID = caseID;
        this.takenDays = takenDays;
        this.courtFee = courtFee;
        this.travelFee = travelFee;
        this.complexity = complexity;
        this.expertFee = expertFee;
        this.adminCost = adminCost;
    }

    public Bill () {}

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public int getTakenDays() {
        return takenDays;
    }

    public void setTakenDays(int takenDays) {
        this.takenDays = takenDays;
    }

    public double getCourtFee() {
        return courtFee;
    }

    public void setCourtFee(double courtFee) {
        this.courtFee = courtFee;
    }

    public double getTravelFee() {
        return travelFee;
    }

    public void setTravelFee(double travelFee) {
        this.travelFee = travelFee;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    public double getExpertFee() {
        return expertFee;
    }

    public void setExpertFee(double expertFee) {
        this.expertFee = expertFee;
    }

    public double getAdminCost() {
        return adminCost;
    }

    public void setAdminCost(double adminCost) {
        this.adminCost = adminCost;
    }


}
