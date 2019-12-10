package Lab5_6.database;

import Lab5_6.exceptions.DatabaseConnectException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStructure extends ConnectManager {
    private static final String CREATE_ACT = "CREATE TABLE act (id SERIAL NOT NULL PRIMARY KEY, name VARCHAR(50), genre VARCHAR(50))";
    private static final String DROP_ACT = "DROP TABLE act";

    private static final String CREATE_ACTORS = "CREATE TABLE actors (id SERIAL NOT NULL PRIMARY KEY, first_name VARCHAR(20), last_name VARCHAR(20), birthday DATE, salary DOUBLE PRECISION)";
    private static final String DROP_ACTORS = "DROP TABLE actors";

    private static final String CREATE_ACTORS_ROLE = "CREATE TABLE actors_role (id SERIAL NOT NULL PRIMARY KEY, actor_id INTEGER NOT NULL REFERENCES actors(id) ON DELETE CASCADE, role VARCHAR(20))";
    private static final String DROP_ACTORS_ROLE = "DROP TABLE actors_role";

    private static final String CREATE_SCHEDULE = "CREATE TABLE schedule (id SERIAL NOT NULL PRIMARY KEY, act_id INTEGER NOT NULL REFERENCES act(id), date DATE, time TIME, price DOUBLE PRECISION)";
    private static final String DROP_SCHEDULE = "DROP TABLE schedule";


    public static void createTables() throws SQLException {
        ConnectManager connectManager = new ConnectManager();
        try (Connection connection = connectManager.createConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(CREATE_ACT);
            statement.execute(CREATE_ACTORS);
            statement.execute(CREATE_ACTORS_ROLE);
            statement.execute(CREATE_SCHEDULE);
        }
        catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }

    public static void dropTables() throws SQLException {
        ConnectManager connectManager = new ConnectManager();
        try (Connection connection = connectManager.createConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(DROP_SCHEDULE);
            statement.execute(DROP_ACTORS_ROLE);
            statement.execute(DROP_ACTORS);
            statement.execute(DROP_ACT);
        }
        catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }

}
