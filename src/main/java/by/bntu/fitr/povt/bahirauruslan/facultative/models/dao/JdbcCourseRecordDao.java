package by.bntu.fitr.povt.bahirauruslan.facultative.models.dao;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.CourseRecord;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCourseRecordDao extends JdbcDao<CourseRecord> {
    private static JdbcCourseRecordDao jdbcCourseRecordDao;

    private JdbcCourseRecordDao() {

    }

    public static JdbcCourseRecordDao getInstance() {
        if (jdbcCourseRecordDao == null) {
            jdbcCourseRecordDao = new JdbcCourseRecordDao();
        }

        return jdbcCourseRecordDao;
    }

    @Override
    protected CourseRecord convert(ResultSet set) throws SQLException {
        CourseRecord courseRecord = new CourseRecord();
        courseRecord.setId(set.getInt("id"));
        courseRecord.setCourse(JdbcCourseDao.getInstance().get(set.getInt("courseId")));
        courseRecord.setStudent(JdbcAccountDao.getInstance().get(set.getInt("studentId")));
        courseRecord.setMark(set.getInt("mark"));
        courseRecord.setReview(set.getString("review"));
        courseRecord.setDate(set.getDate("finishDate"));
        return courseRecord;
    }

    @Override
    protected void setToAddStatement(PreparedStatement statement, CourseRecord courseRecord) throws SQLException {
        statement.setInt(1, courseRecord.getCourse().getId());
        statement.setInt(2, courseRecord.getStudent().getId());
        statement.setInt(3, courseRecord.getMark());
        statement.setString(4, courseRecord.getReview());
        statement.setDate(5, courseRecord.getDate());
    }

    @Override
    protected void setToDeleteStatement(PreparedStatement statement, CourseRecord courseRecord) throws SQLException {
        statement.setInt(1, courseRecord.getId());
    }

    @Override
    protected void setToUpdateStatement(PreparedStatement statement, CourseRecord courseRecord) throws SQLException {
        setToAddStatement(statement, courseRecord);
        statement.setInt(6, courseRecord.getId());
    }

    @Override
    protected String getAllStatementSQL() {
        return "SELECT * FROM courseRecords";
    }

    @Override
    protected String getStatementSQL() {
        return "SELECT * FROM courseRecords WHERE id = ?";
    }

    @Override
    protected String addStatementSQL() {
        return "INSERT INTO courseRecords (courseId, studentId, mark, review, finishDate) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected String deleteStatementSQL() {
        return "DELETE FROM courseRecords WHERE id = ?";
    }

    @Override
    protected String updateStatementSQL() {
        return "UPDATE courseRecords SET courseId = ?, studentId = ?, mark = ?, review = ?, finishDate = ? WHERE id = ?";
    }
}
