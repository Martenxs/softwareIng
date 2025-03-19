package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Singleton {
    private static Singleton singleton;
    private Connection connection;

    private Singleton() throws SQLException {
        ResourceBundle bundle = ResourceBundle.getBundle("config");

        String url = bundle.getString("db.url");
        String user = bundle.getString("db.user");
        String password = bundle.getString("db.password");

        connection = DriverManager.getConnection(url, user, password);
    }

    public static Singleton getInstance() throws SQLException {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public Connection getConnection() {
        return connection;
    }
}
