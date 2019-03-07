package by.bntu.fitr.povt.bahirauruslan.facultative.models.dao;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Permission;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcPermissionDao extends JdbcDao<Permission> {
    private static JdbcPermissionDao jdbcPermissionDao;

    private JdbcPermissionDao() {

    }

    public static JdbcPermissionDao getInstance() {
        if (jdbcPermissionDao == null) {
            jdbcPermissionDao = new JdbcPermissionDao();
        }

        return jdbcPermissionDao;
    }

    @Override
    protected Permission convert(ResultSet set) throws SQLException {
        Permission permission = new Permission();
        permission.setId(set.getInt("id"));
        permission.setName(set.getString("permissionName"));
        return permission;
    }

    @Override
    protected void setToAddStatement(PreparedStatement statement, Permission permission) throws SQLException {
        statement.setString(1, permission.getName());
    }

    @Override
    protected void setToDeleteStatement(PreparedStatement statement, Permission permission) throws SQLException {
        statement.setInt(1, permission.getId());
    }

    @Override
    protected void setToUpdateStatement(PreparedStatement statement, Permission permission) throws SQLException {
        setToAddStatement(statement, permission);
        statement.setInt(2, permission.getId());
    }

    @Override
    protected String getAllStatementSQL() {
        return "SELECT * FROM permissions";
    }

    @Override
    protected String getStatementSQL() {
        return "SELECT * FROM permissions WHERE id = ?";
    }

    @Override
    protected String addStatementSQL() {
        return "INSERT INTO permissions (permissionName) VALUES (?)";
    }

    @Override
    protected String deleteStatementSQL() {
        return "DELETE FROM permissions WHERE id = ?";
    }

    @Override
    protected String updateStatementSQL() {
        return "UPDATE permissions SET permissionName = ? WHERE id = ?";
    }
}
