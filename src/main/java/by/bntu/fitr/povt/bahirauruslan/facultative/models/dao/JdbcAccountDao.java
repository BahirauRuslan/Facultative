package by.bntu.fitr.povt.bahirauruslan.facultative.models.dao;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcAccountDao extends JdbcDao<Account> {
    private static JdbcAccountDao jdbcAccountDao;

    private JdbcAccountDao() {

    }

    public static JdbcAccountDao getInstance() {
        if (jdbcAccountDao == null) {
            jdbcAccountDao = new JdbcAccountDao();
        }

        return jdbcAccountDao;
    }

    @Override
    protected Account convert(ResultSet set) throws SQLException {
        Account account = new Account();
        account.setId(set.getInt("id"));
        account.setLogin(set.getString("login"));
        account.setHash(set.getString("passwordHash"));
        account.setFullName(set.getString("fullName"));
        account.setAvailable(set.getBoolean("isAvailable"));
        return account;
    }

    @Override
    protected void setToAddStatement(PreparedStatement statement, Account account) throws SQLException {
        statement.setString(1, account.getLogin());
        statement.setString(2, account.getHash());
        statement.setString(3, account.getFullName());
        statement.setInt(4, account.getPermission().getId());
        statement.setBoolean(5, account.isAvailable());
    }

    @Override
    protected void setToDeleteStatement(PreparedStatement statement, Account account) throws SQLException {
        statement.setInt(1, account.getId());
    }

    @Override
    protected void setToUpdateStatement(PreparedStatement statement, Account account) throws SQLException {
        setToAddStatement(statement, account);
        statement.setInt(6, account.getId());
    }

    @Override
    protected String getAllStatementSQL() {
        return "SELECT * FROM accounts";
    }

    @Override
    protected String getStatementSQL() {
        return "SELECT * FROM accounts WHERE id = ?";
    }

    @Override
    protected String addStatementSQL() {
        return "INSERT INTO accounts (login, passwordHash, fullName, permissionId, isAvailable) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected String deleteStatementSQL() {
        return "DELETE FROM accounts WHERE id = ?";
    }

    @Override
    protected String updateStatementSQL() {
        return "UPDATE accounts SET login = ?, passwordHash = ?, fullName = ?, permissionId = ?, isAvailable = ? WHERE id = ?";
    }
}
