package App.Individuals;

public class Speaker extends Person {
    private String organization;

    public Speaker(String name, String email, String organization) {
        super(name, email);
        this.organization = organization;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
