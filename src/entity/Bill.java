package entity;

public class Bill {
    private int billID;
    private int caseID;
    private int takenDays;
    private double CourtFee;
    private double travelFee;
    private Complexity complexity;
    private double expertFee;
    private double AdminCost;

    public Bill(int caseID, int takenDays, double courtFee, double travelFee, Complexity complexity, double expertFee, double adminCost) {
        this.caseID = caseID;
        this.takenDays = takenDays;
        CourtFee = courtFee;
        this.travelFee = travelFee;
        this.complexity = complexity;
        this.expertFee = expertFee;
        AdminCost = adminCost;
    }

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
        return CourtFee;
    }

    public void setCourtFee(double courtFee) {
        CourtFee = courtFee;
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
        return AdminCost;
    }

    public void setAdminCost(double adminCost) {
        AdminCost = adminCost;
    }

//    public double calculateTotalEstimate(){}
    // public double CostEstimator(int billID,int caseID, int takenDays, double courtFee, double travelFee, Complexity complexity, double expertFee, double adminCost){}
}
