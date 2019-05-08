package by.bntu.fitr.povt.bahirauruslan.facultative.models.services.student;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.IDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.JdbcCourseRecordDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Account;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Course;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.CourseRecord;

import java.util.ArrayList;
import java.util.List;

public class CourseRecordService {
    private IDao<CourseRecord, Integer> dao = JdbcCourseRecordDao.getInstance();

    public void subscribeToCourses(Account student, Course course) {
        CourseRecord record = new CourseRecord();
        record.setCourse(course);
        record.setStudent(student);
        dao.add(record);
    }

    public List<CourseRecord> getCourseRecords(Account student) {
        List<CourseRecord> records = new ArrayList<>();
        for (CourseRecord record : dao.getAll()) {
            if (record.getStudent().equals(student)) {
                records.add(record);
            }
        }

        return records;
    }

    public int getCurrentCoursesCount(Account student)
    {
        int count = 0;
        for (CourseRecord record : getCourseRecords(student)) {
            if (record.getDate() == null)
            {
                count++;
            }
        }

        return count;
    }

    public int getOldCoursesCount(Account student) {
        return getCourseRecords(student).size() - getCurrentCoursesCount(student);
    }

    public CourseRecord getCourseRecord(int id) {
        return dao.get(id);
    }
}
