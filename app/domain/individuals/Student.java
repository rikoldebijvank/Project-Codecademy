package app.domain.individuals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import app.domain.Course;
import app.domain.Registration;
import app.domain.content.Module;
import javafx.scene.control.Button;

public class Student extends Person {
    private LocalDate birthday;
    private String gender;
    private String address;
    private String residence;
    private String country;
    private HashMap<String, Course> courseList;
    private Button removeStudentButton;

    // constructor methode
    public Student(String name, String email, LocalDate birthday, String gender, String address, String residence,
                   String country) {
        super(name, email);
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.residence = residence;
        this.country = country;
        this.courseList = new HashMap<>();
    }

    // andere constructor
    public Student(String name, String email, String gender, Button button) {
        super(name, email);
        this.gender = gender;
        this.removeStudentButton = button;
    }

    // andere constructor
    public Student(String name, Button studentButton) {
        super(name);
        this.removeStudentButton = studentButton;
    }

    // andere constructor
    public Student(String name) {
        super(name);
    }

    // setters en getters
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public HashMap<String, Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(HashMap<String, Course> courseList) {
        this.courseList = courseList;
    }

    public Button getRemoveStudentButton() {
        return removeStudentButton;
    }

    public void setRemoveStudentButton(Button removeStudentButton) {
        this.removeStudentButton = removeStudentButton;
    }
}
