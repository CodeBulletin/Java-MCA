package ConnectionCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    private String url, username, password;
    private Connection connection = null;

    private ConnectionCreator() {}

    public static ConnectionCreator create(String url) {
        ConnectionCreator creator = new ConnectionCreator();
        creator.url = url;
        return creator;
    }
    public ConnectionCreator setUsername(String username) {
        this.username = username;
        return this;
    }
    public ConnectionCreator setPassword(String password) {
        this.password = password;
        return this;
    }
    public ConnectionCreator connect() throws SQLException{
        this.connection = DriverManager.getConnection(url, username, password);
        return this;
    }
    public Connection getConnection() {
        return connection;
    }
}