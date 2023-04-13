package app.domain;

import java.time.LocalDate;

public class Registration {
    private Course course;
    private String studentEmail;
    private LocalDate date;

    // constructor methode
    public Registration(Course course, String studentEmail, LocalDate date) {
        this.course = course;
        this.studentEmail = studentEmail;
        this.date = date;
    }

    // setters en getters
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
