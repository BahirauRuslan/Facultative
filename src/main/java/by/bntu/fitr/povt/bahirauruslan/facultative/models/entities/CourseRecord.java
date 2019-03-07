package by.bntu.fitr.povt.bahirauruslan.facultative.models.entities;

import java.sql.Date;

public class CourseRecord {
    private int id;
    private Account student;
    private Course course;
    private Integer mark;
    private String review;
    private Date date;

    public CourseRecord() {
    }

    public CourseRecord(int id, Account student, Course course, Integer mark, String review, Date date) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.mark = mark;
        this.review = review;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getStudent() {
        return student;
    }

    public void setStudent(Account student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseRecord that = (CourseRecord) o;

        if (id != that.id) return false;
        if (!student.equals(that.student)) return false;
        if (!course.equals(that.course)) return false;
        if (mark != null ? !mark.equals(that.mark) : that.mark != null) return false;
        if (review != null ? !review.equals(that.review) : that.review != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + student.hashCode();
        result = 31 * result + course.hashCode();
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CourseRecord{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", mark=" + mark +
                ", review='" + review + '\'' +
                ", date=" + date +
                '}';
    }
}
