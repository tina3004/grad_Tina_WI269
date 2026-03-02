import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        Connection con = null;

        // retry until DB is ready
        while (con == null) {
            try {

                System.out.println("Trying to connect to database...");

                con = DriverManager.getConnection(
                        "jdbc:postgresql://db:5432/docker_db",
                        "postgres",
                        "Tina3004!"
                );

                System.out.println("Connected!");

            } catch (Exception e) {

                System.out.println("Database not ready, retrying in 3 seconds...");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }

        try {

            Statement stmt = con.createStatement();

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS student(id INT, name VARCHAR(50));"
            );

            stmt.executeUpdate(
                    "INSERT INTO student VALUES (1, 'Tina');"
            );

            System.out.println("Record inserted successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}