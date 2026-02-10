import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApprovalDAO implements ApprovalDAOInterface{

    public void createRequest(int siteno, int userId) {
        String sql = "INSERT INTO approval (siteno, user_id, status) VALUES (?, ?, 'PENDING')";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, siteno);
            ps.setInt(2, userId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Approval> getPendingRequests() {
        List<Approval> list = new ArrayList<>();
        String sql = "SELECT * FROM approval WHERE status = 'PENDING'";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Approval(
                        rs.getInt("id"),
                        rs.getInt("siteno"),
                        rs.getInt("user_id"),
                        rs.getString("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStatus(int approvalId, String status) {
        String sql = "UPDATE approval SET status = ? WHERE id = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, approvalId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
