package by.bntu.fitr.povt.bahirauruslan.facultative.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import by.bntu.fitr.povt.bahirauruslan.facultative.connection.ConnectionPull;

public abstract class JdbcDao<T> implements IDao<T, Integer> {
    @Override
    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        try (Connection connection = ConnectionPull.INSTANCE.retrieve();
             PreparedStatement statement = connection.prepareStatement(getAllStatementSQL())) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                list.add(convert(set));
            }
            ConnectionPull.INSTANCE.putBack(connection);
        } catch (Exception e) {
            //TODO: add logger
        }

        return list;
    }

    @Override
    public T get(Integer key) {
        T t = null;
        try (Connection connection = ConnectionPull.INSTANCE.retrieve();
             PreparedStatement statement = connection.prepareStatement(getStatementSQL())) {
            statement.setInt(1, key);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                t = convert(set);
            }
            ConnectionPull.INSTANCE.putBack(connection);
        } catch (Exception e) {
            //TODO: add logger
        }

        return t;
    }

    @Override
    public boolean add(T entity) {
        try (Connection connection = ConnectionPull.INSTANCE.retrieve();
             PreparedStatement statement = connection.prepareStatement(addStatementSQL())) {
            setToAddStatement(statement, entity);
            commitUpdates(connection,statement);
            ConnectionPull.INSTANCE.putBack(connection);
            return true;
        } catch (Exception e) {
            //TODO: add logger
            return false;
        }
    }

    @Override
    public boolean delete(T entity) {
        try (Connection connection = ConnectionPull.INSTANCE.retrieve();
             PreparedStatement statement = connection.prepareStatement(deleteStatementSQL())) {
            setToDeleteStatement(statement, entity);
            statement.execute();
            ConnectionPull.INSTANCE.putBack(connection);
            return true;
        } catch (Exception e) {
            //TODO: add logger
            return false;
        }
    }

    @Override
    public boolean update(T entity) {
        try (Connection connection = ConnectionPull.INSTANCE.retrieve();
             PreparedStatement statement = connection.prepareStatement(updateStatementSQL())) {
            setToUpdateStatement(statement, entity);
            commitUpdates(connection, statement);
            ConnectionPull.INSTANCE.putBack(connection);
            return true;
        } catch (Exception e) {
            //TODO: add logger
            return false;
        }
    }

    protected void commitUpdates(Connection connection,
                                 PreparedStatement statement) throws SQLException {
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
    }

    protected abstract T convert(ResultSet set) throws SQLException;
    protected abstract void setToAddStatement(PreparedStatement statement, T t) throws SQLException;
    protected abstract void setToDeleteStatement(PreparedStatement statement,
                                                 T t) throws SQLException;
    protected abstract void setToUpdateStatement(PreparedStatement statement,
                                                 T t) throws SQLException;
    protected abstract String getAllStatementSQL();
    protected abstract String getStatementSQL();
    protected abstract String addStatementSQL();
    protected abstract String deleteStatementSQL();
    protected abstract String updateStatementSQL();
}
