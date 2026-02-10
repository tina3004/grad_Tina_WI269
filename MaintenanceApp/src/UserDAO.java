

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDAOInterface{

    public User getUserByName(String name){
        User user=null;
        String sql="select * from users where name=?";

        try{
            Connection con=DBUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,name);

            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                user=new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getString("password"),
                        rs.getString("status"),
                        (Integer) rs.getObject("siteno")
                );
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return user;
    }

    public void addOwner(User user) {
        String sql = "INSERT INTO users (name, role, password, status, siteno) VALUES (?, 'OWNER', ?, ?, ?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getStatus());
            ps.setInt(4, user.getSiteno());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOwner(User user) {
        String sql = "UPDATE users SET name = ?, status = ? WHERE id = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getStatus());
            ps.setInt(3, user.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOwner(int userId) {
        String sql = "DELETE FROM users WHERE id = ? AND role = 'OWNER'";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
