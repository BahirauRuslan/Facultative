package by.bntu.fitr.povt.bahirauruslan.facultative.models.services.student;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.IDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.JdbcCourseDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.*;

import java.util.*;

public class CourseService {
    private IDao<Course, Integer> dao = JdbcCourseDao.getInstance();

    public List<Course> getAllNonSubscribedCourses(Account account) {
        List<Course> all = dao.getAll();
        List<Course> result = new ArrayList<>();
        List<CourseRecord> courseRecords = new CourseRecordService().getCourseRecords(account);
        for (int i = 0; i < all.size(); i++) {
            boolean valid = true;
            for (CourseRecord record : courseRecords) {
                if (record.getCourse().equals(all.get(i)))
                {
                    valid = false;
                }
            }
            if (valid) {
                result.add(all.get(i));
            }
        }
        return result;
    }

    public Course getCourse(int id) {
        return dao.get(id);
    }
}
