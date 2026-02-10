public class User {
    private int id;
    private String name;
    private String role;
    private String password;
    private String status;
    private Integer siteno;

    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSiteno() {
        return siteno;
    }

    public void setSiteno(Integer siteno) {
        this.siteno = siteno;
    }

    public User(int id, String name, String role, String password, String status, Integer siteno) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
        this.status = status;
        this.siteno = siteno;
    }

}
