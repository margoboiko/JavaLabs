package Lab5_6.database;


import Lab5_6.exceptions.DatabaseConnectException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectManager {
private Properties properties;

        {
        properties = new Properties();
        }

public ConnectManager() { }

public Connection createConnection() {
        try {
        properties.load(new FileInputStream("C:\\Users\\Rita\\Downloads\\JavaLabs\\Lab0\\out\\resources\\database.properties"));

//        Class.forName(properties.getProperty("org.postgresql.Driver"));
                properties.getProperty("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(
                properties.getProperty("jdbc.url"),
                properties.getProperty("login"),
                properties.getProperty("password")
        );
        return connection;
        }
        catch (SQLException | IOException ex) {
         throw new DatabaseConnectException(ex.getMessage());
        }
        }

        public static Connection getConnection()throws SQLException {
                return new ConnectManager().createConnection();
        }

}