package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Data implements AutoCloseable {
    private Connection connection;

    public Data() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=StoreClothes;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "123";
        connection = DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
