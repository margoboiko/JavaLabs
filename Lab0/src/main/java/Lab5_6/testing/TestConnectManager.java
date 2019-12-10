package Lab5_6.testing;

import Lab5_6.database.ConnectManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnectManager {

    @Test
    public void getConnectTest() {
        Connection connection = new ConnectManager().createConnection();
        try {
            connection.close();
        } catch (SQLException e) {
            Assert.fail();
        }
    }
}