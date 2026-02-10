import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SiteDAO implements SiteDAOInterface{

    public List<Site> getAllSites() {
        List<Site> list = new ArrayList<>();
        String sql = "SELECT * FROM site ORDER BY siteno";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Site(
                        rs.getInt("siteno"),
                        rs.getString("type"),
                        rs.getInt("len"),
                        rs.getInt("breadth"),
                        rs.getBoolean("is_occupied")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Site getSiteBySiteno(int siteno) {
        Site site = null;
        String sql = "SELECT * FROM site WHERE siteno = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, siteno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                site = new Site(
                        rs.getInt("siteno"),
                        rs.getString("type"),
                        rs.getInt("len"),
                        rs.getInt("breadth"),
                        rs.getBoolean("is_occupied")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return site;
    }

    public void updateSite(Site site) {
        String sql = "UPDATE site SET type = ?, is_occupied = ? WHERE siteno = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, site.getType());
            ps.setBoolean(2, site.isOccupied());
            ps.setInt(3, site.getSiteno());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
