package by.bntu.fitr.povt.bahirauruslan.facultative.connection;

import by.bntu.fitr.povt.bahirauruslan.facultative.exceptions.DBDriverNotFoundException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class Jdbc {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/Facultative";
    private static final String NAME = "root";
    private static final String PASSWORD = "123456";
    private static final Logger logger = Logger.getLogger(Jdbc.class);

    private Connection connection;

    public Jdbc() throws DBDriverNotFoundException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error("Database driver not found");
            throw new DBDriverNotFoundException();
        }
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        }

        return connection;
    }
}
