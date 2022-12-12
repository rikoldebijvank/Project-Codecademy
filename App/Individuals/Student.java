package App.Individuals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import App.CourseMaterial.Certificate;
import App.CourseMaterial.Course;
import App.CourseMaterial.Registration;
import App.CourseMaterial.Content.Module;

public class Student extends Person {
    private LocalDate birthday;
    private String gender;
    private String address;
    private String residence;
    private String country;
    private ArrayList<Certificate> certificateList;
    private HashMap<String, Course> courseList;

    public Student(String name, String email, LocalDate birthday, String gender, String address, String residence,
            String country) {
        super(name, email);
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.residence = residence;
        this.country = country;
        this.certificateList = new ArrayList<>();
        this.courseList = new HashMap<>();
    }

    public int perctRead() {
        // Method moet nog ingevuld worden
        return 0;
    }

    public void enrollCourse(Course course, LocalDate date) {
        Registration newRegistration = new Registration(course, super.getEmail(), date);
        courseList.put(course.getCourseName(), course);
        // Moet nog aan toegevoegd worden
    }

    public Double perctDoneModule(Course course, Module module) {
        // Method moet nog ingevuld worden
        return 0.0;
    }

    public void showCertificates() {
        StringBuilder builder = new StringBuilder();
        Iterator<Certificate> iterator = certificateList.iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next());
        }
        System.out.println(builder);
    }

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

    public ArrayList<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(ArrayList<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    public HashMap<String, Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(HashMap<String, Course> courseList) {
        this.courseList = courseList;
    }
}
