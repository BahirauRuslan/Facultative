package by.bntu.fitr.povt.bahirauruslan.facultative.connection;

import by.bntu.fitr.povt.bahirauruslan.facultative.exceptions.ConnectionPullOverflowException;
import by.bntu.fitr.povt.bahirauruslan.facultative.exceptions.DBDriverNotFoundException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public enum ConnectionPull {
    INSTANCE;
    private static final int UPPER_BOUND_COUNT = 100;

    private Vector<Connection> availableConnections = new Vector<>();
    private Vector<Connection> usedConnections = new Vector<>();
    private Jdbc jdbc;

    public synchronized Connection retrieve() throws SQLException,
            DBDriverNotFoundException, ConnectionPullOverflowException {
        jdbc = new Jdbc();
        Connection newConnection;
        if (usedConnections.size() > UPPER_BOUND_COUNT) {
            throw new ConnectionPullOverflowException();
        }
        if (availableConnections.size() == 0) {
            newConnection = getConnection();
        } else {
            newConnection = availableConnections.lastElement();
            availableConnections.removeElement(newConnection);
        }
        usedConnections.addElement(newConnection);
        return newConnection;
    }

    public synchronized void putBack(Connection c) {
        if (c != null) {
            if (usedConnections.removeElement(c)) {
                availableConnections.addElement(c);
            }
        }
    }

    public int getAvailableConnectionsCount() {
        return availableConnections.size();
    }

    private Connection getConnection() throws SQLException {
        return jdbc.getConnection();
    }
}
