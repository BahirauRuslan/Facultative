package by.bntu.fitr.povt.bahirauruslan.facultative.models.services.admin;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Course;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Account;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.IDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.JdbcCourseDao;

import java.util.List;

public class CourseService {
    private IDao<Course, Integer> dao = JdbcCourseDao.getInstance();

    public List<Course> getAllCourses() {
        return dao.getAll();
    }

    public Course getCourse(int id) {
        return dao.get(id);
    }

    public void addCourse(Account teacher, String name, String description) {
        Course course = new Course();
        course.setTeacher(teacher);
        course.setName(name);
        course.setDescription(description);
        dao.add(course);
    }

    public void updateCourse(Course course, Account teacher, String name, String description) {
        course.setTeacher(teacher);
        course.setName(name);
        course.setDescription(description);
        dao.update(course);
    }

    public void deleteCourse(Course course) {
        dao.delete(course);
    }
}
