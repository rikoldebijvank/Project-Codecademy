package app.domain.content;

import java.time.LocalDate;

import app.domain.individuals.ContactPerson;

public class Module extends Content {
    private String courseName;
    private Double version;
    private int moduleNumber;
    private ContactPerson contactPerson;
    private Integer percentageFinished;

    // constructor methode
    public Module(String title, String description, LocalDate publicationDate, Status status, int contentId,
            Double version, int moduleNumber, ContactPerson contactPerson) {
        super(title, description, publicationDate, contentId, status);
        this.version = version;
        this.moduleNumber = moduleNumber;
        this.contactPerson = contactPerson;
    }

    // andere constructor
    public Module(String courseName, String title, int percentageFinished) {
        super(title);
        this.courseName = courseName;
        this.percentageFinished = percentageFinished;
    }

    // setters en getters
    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getPercentageFinished() {
        return percentageFinished;
    }

    public void setPercentageFinished(Integer percentageFinished) {
        this.percentageFinished = percentageFinished;
    }

    public String getTitle() {
        return super.title;
    }

}
