package by.bntu.fitr.povt.bahirauruslan.facultative.models.entities;

public class Course {
    private int id;
    private Teacher teacher;
    private String name;
    private String description;

    public Course() {
    }

    public Course(int id, Teacher teacher, String name, String description) {
        this.id = id;
        this.teacher = teacher;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (!teacher.equals(course.teacher)) return false;
        if (!name.equals(course.name)) return false;
        return description != null ? description.equals(course.description) : course.description == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + teacher.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
