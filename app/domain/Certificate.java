package app.domain;

import app.domain.individuals.Employee;

public class Certificate {
    private String courseName;
    private Integer id;
    private Double rating;
    private Employee employee;

    // constructor methode
    public Certificate(int id, Double rating, Employee employee) {
        this.id = id;
        this.rating = rating;
        this.employee = employee;
    }

    // andere constructor methode
    public Certificate(String courseName, int id, Double rating) {
        this.courseName = courseName;
        this.id = id;
        this.rating = rating;
    }

    // setters en getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
