
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class JavaDBConnect {

    private static Connection connection = null;

    public static Connection dbConnection() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection=DriverManager.getConnection("jdbc:sqlite:Log_In.sqlite"); 
            return connection; 

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e); 
            return null; 
        }
    }
}
