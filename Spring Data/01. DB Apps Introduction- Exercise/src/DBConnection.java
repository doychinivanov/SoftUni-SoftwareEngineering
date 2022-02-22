import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    Properties properties = new Properties();

    public DBConnection(String user, String password) {
        this.properties.setProperty("user", user);
        this.properties.setProperty("password", password);
    }

    public Connection setConnection() throws SQLException {
        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
