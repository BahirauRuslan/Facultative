package by.bntu.fitr.povt.bahirauruslan.facultative.models.dao;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCourseDao extends JdbcDao<Course> {
    private static JdbcCourseDao jdbcCourseDao;

    private JdbcCourseDao() {

    }

    public static JdbcCourseDao getInstance() {
        if (jdbcCourseDao == null) {
            jdbcCourseDao = new JdbcCourseDao();
        }

        return jdbcCourseDao;
    }

    @Override
    protected Course convert(ResultSet set) throws SQLException {
        Course course = new Course();
        course.setId(set.getInt("id"));
        course.setName(set.getString("courseName"));
        course.setDescription(set.getString("courseDescription"));
        return course;
    }

    @Override
    protected void setToAddStatement(PreparedStatement statement, Course course) throws SQLException {
        statement.setInt(1, course.getTeacher().getId());
        statement.setString(2, course.getName());
        statement.setString(3, course.getDescription());
    }

    @Override
    protected void setToDeleteStatement(PreparedStatement statement, Course course) throws SQLException {
        statement.setInt(1, course.getId());
    }

    @Override
    protected void setToUpdateStatement(PreparedStatement statement, Course course) throws SQLException {
        setToAddStatement(statement, course);
        statement.setInt(4, course.getId());
    }

    @Override
    protected String getAllStatementSQL() {
        return "SELECT * FROM courses";
    }

    @Override
    protected String getStatementSQL() {
        return "SELECT * FROM courses WHERE id = ?";
    }

    @Override
    protected String addStatementSQL() {
        return "INSERT INTO courses (teacherId, courseName, courseDescription) VALUES (?, ?, ?)";
    }

    @Override
    protected String deleteStatementSQL() {
        return "DELETE FROM courses WHERE id = ?";
    }

    @Override
    protected String updateStatementSQL() {
        return "UPDATE courses SET teacherId = ?, courseName = ?, courseDescription = ? WHERE id = ?";
    }
}
