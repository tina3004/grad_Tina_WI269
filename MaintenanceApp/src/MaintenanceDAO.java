
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDAO implements MaintenanceDAOInterface {

    public void saveMaintenance(Maintenance m) {
        String sql = """
            INSERT INTO maintenance (siteno, user_id, amount, is_paid)
            VALUES (?, ?, ?, ?)
            ON CONFLICT (siteno)
            DO UPDATE SET amount = EXCLUDED.amount, is_paid = EXCLUDED.is_paid
        """;

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, m.getSiteno());
            ps.setInt(2, m.getUserId());
            ps.setDouble(3, m.getAmount());
            ps.setBoolean(4, m.isPaid());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Maintenance getMaintenance(int siteno) {
        Maintenance m = null;
        String sql = "SELECT * FROM maintenance WHERE siteno = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, siteno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new Maintenance(
                        rs.getInt("siteno"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getBoolean("is_paid")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    public List<Maintenance> getUnpaidMaintenance() {
        List<Maintenance> list = new ArrayList<>();
        String sql = "SELECT * FROM maintenance WHERE is_paid = false";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Maintenance(
                        rs.getInt("siteno"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getBoolean("is_paid")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void markAsPaid(int siteno) {
        String sql = "UPDATE maintenance SET is_paid = true WHERE siteno = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, siteno);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
