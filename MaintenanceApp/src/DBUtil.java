import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static Connection getConnection(){
        Connection con=null;

        try{
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Layout_Maintenance_App","postgres","Tina3004!");

        }
        catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}
