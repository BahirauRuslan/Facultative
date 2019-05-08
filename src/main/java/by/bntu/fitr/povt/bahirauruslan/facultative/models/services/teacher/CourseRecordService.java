package by.bntu.fitr.povt.bahirauruslan.facultative.models.services.teacher;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.IDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.JdbcCourseRecordDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Account;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Course;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.CourseRecord;

import java.util.ArrayList;
import java.util.List;

public class CourseRecordService {
    private IDao<CourseRecord, Integer> dao = JdbcCourseRecordDao.getInstance();

    public List<CourseRecord> getCourseRecords(Course course) {
        List<CourseRecord> records = new ArrayList<>();
        for (CourseRecord record : dao.getAll()) {
            if (record.getCourse().equals(course)) {
                records.add(record);
            }
        }

        return records;
    }

    public void setReviewAndMark(CourseRecord record, int mark, String review) {
        record.setMark(mark);
        record.setReview(review);
        dao.update(record);
    }

    public CourseRecord getCourseRecord(int id) {
        return dao.get(id);
    }
}
