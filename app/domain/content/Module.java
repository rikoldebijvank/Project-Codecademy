package app.domain.content;

import java.time.LocalDate;

import app.domain.individuals.ContactPerson;

public class Module extends Content {
    private String courseName;
    private double version;
    private int moduleNumber;
    private ContactPerson contactPerson;
    private Integer averageProgress;
    private String progress;
    private String studentName;

    // constructor methode
    public Module(String courseName, String title, Integer averageProgress) {
        super(title);
        this.courseName = courseName;
        this.averageProgress = averageProgress;
    }

    // andere constructor
    public Module(String title, String description, LocalDate publicationDate, Status status, int contentId,
            double version, int moduleNumber, ContactPerson contactPerson) {
        super(title, description, publicationDate, contentId, status);
        this.version = version;
        this.moduleNumber = moduleNumber;
        this.contactPerson = contactPerson;
    }

    // andere constructor methode
    public Module(String title, String studentName, String progress) {
        super(title);
        this.studentName = studentName;
        this.progress = progress;
    }

    // setters en getters

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public int getModuleNumber() {
        return moduleNumber;
    }

    public void setModuleNumber(int moduleNumber) {
        this.moduleNumber = moduleNumber;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Integer getAverageProgress() {
        return averageProgress;
    }

    public void setAverageProgress(Integer averageProgress) {
        this.averageProgress = averageProgress;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    
}
