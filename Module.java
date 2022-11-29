import java.time.LocalDate;

public class Module extends Content {
    private Double version;
    private int moduleNumber;
    private ContactPerson contactPerson;

    public Module(String title, String description, LocalDate publicationDate, Status status, int contentId,
            Double version, int moduleNumber, ContactPerson contactPerson) {
        super(title, description, publicationDate, contentId, status);
        this.version = version;
        this.moduleNumber = moduleNumber;
        this.contactPerson = contactPerson;
    }

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

}
