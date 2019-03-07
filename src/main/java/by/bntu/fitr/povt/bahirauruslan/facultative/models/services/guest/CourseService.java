package by.bntu.fitr.povt.bahirauruslan.facultative.models.services.guest;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.IDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.JdbcCourseDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Course;

import java.util.List;

public class CourseService {
    private IDao<Course, Integer> dao = JdbcCourseDao.getInstance();

    public List<Course> getAllCourses() {
        return dao.getAll();
    }

    public Course getCourse(int id) {
        return dao.get(id);
    }
}
