package app.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import app.domain.content.Content;
import app.domain.content.Module;
import app.domain.content.Webcast;
import javafx.scene.control.Button;

public class Course {
    private Button courseButton;
    private String courseName;
    private String subject;
    private String introduction;
    private String adminEmail;
    private Integer studentsFinished;
    private Difficulty difficulty;
    private ArrayList<Course> recommendedCourses;
    private HashMap<String, Content> content;

    // constructor methode
    public Course(String courseName, String subject, String intro, Difficulty difficulty, String adminEmail) {
        this.courseName = courseName;
        this.subject = subject;
        this.introduction = intro;
        this.difficulty = difficulty;
        this.adminEmail = adminEmail;
        this.recommendedCourses = new ArrayList<>();
        this.content = new HashMap<>();
    }

    // andere constructor methode
    public Course(String courseName, String subject, Difficulty difficultyNames,
            int studentsFinished) {
        this.courseName = courseName;
        this.subject = subject;
        this.difficulty = difficultyNames;
        this.studentsFinished = studentsFinished;
    }

    // andere constructor methode
    public Course(Button courseButton, String courseName) {
        this.courseButton = courseButton;
        this.courseName = courseName;
    }

     // andere constructor methode
     public Course(String courseName) {
        this.courseName = courseName;
    }

    // setters en getters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public ArrayList<Course> getRecommendedCourses() {
        return recommendedCourses;
    }

    public void setRecommendedCourses(ArrayList<Course> recommendedCourses) {
        this.recommendedCourses = recommendedCourses;
    }

    public HashMap<String, Content> getContent() {
        return content;
    }

    public void setContent(HashMap<String, Content> content) {
        this.content = content;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public Integer getStudentsFinished() {
        return studentsFinished;
    }

    public void setStudentsFinished(Integer studentsFinished) {
        this.studentsFinished = studentsFinished;
    }

    public Button getCourseButton() {
        return courseButton;
    }

    public void setCourseButton(Button courseButton) {
        this.courseButton = courseButton;
    }
}
