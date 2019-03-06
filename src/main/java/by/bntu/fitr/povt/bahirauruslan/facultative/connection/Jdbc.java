package by.bntu.fitr.povt.bahirauruslan.facultative.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/Facultative";
    private static final String NAME = "root";
    private static final String PASSWORD = "123456";

    private Connection connection;

    public Jdbc() throws ClassNotFoundException {
        Class.forName(DRIVER);
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        }

        return connection;
    }
}