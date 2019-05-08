package by.bntu.fitr.povt.bahirauruslan.facultative.models.services.teacher;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Course;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Account;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private by.bntu.fitr.povt.bahirauruslan.facultative.models.services.guest.CourseService courseService
            = new by.bntu.fitr.povt.bahirauruslan.facultative.models.services.guest.CourseService();

    public List<Course> getAllCourses(Account teacher) {
        List<Course> courses = courseService.getAllCourses();
        List<Course> filtered = new ArrayList<>();
        for (Course course : courses) {
            if (course.getTeacher().equals(teacher)) {
                filtered.add(course);
            }
        }
        return filtered;
    }

    public Course getCourse(int id) {
        return courseService.getCourse(id);
    }
}
