public class Approval {

    private int id;
    private int siteno;
    private int userId;
    private String status;

    public Approval() {
    }

    public Approval(int id, int siteno, int userId, String status) {
        this.id = id;
        this.siteno = siteno;
        this.userId = userId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
