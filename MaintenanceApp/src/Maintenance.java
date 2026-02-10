    public class Maintenance {

    private int siteno;
    private int userId;
    private double amount;
    private boolean isPaid;

    public Maintenance() {
    }

    public Maintenance(int siteno, int userId, double amount, boolean isPaid) {
        this.siteno = siteno;
        this.userId = userId;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public int getSiteno() {
        return siteno;
    }

    public void setSiteno(int siteno) {
        this.siteno = siteno;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
