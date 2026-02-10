public class Site {
    private int siteno;
    private String type;
    private int len;
    private int breadth;
    private boolean isOccupied;

    public Site(){

    }

    public Site(int siteno, String type, int len, int breadth, boolean isOccupied) {
        this.siteno = siteno;
        this.type = type;
        this.len = len;
        this.breadth = breadth;
        this.isOccupied = isOccupied;
    }

    public int getSiteno() {
        return siteno;
    }

    public void setSiteno(int siteno) {
        this.siteno = siteno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
