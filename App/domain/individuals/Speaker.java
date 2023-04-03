package app.domain.individuals;

public class Speaker extends Person {
    private String organization;

    // constructor methode
    public Speaker(String name, String email, String organization) {
        super(name, email);
        this.organization = organization;
    }

    // setters en getters
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
