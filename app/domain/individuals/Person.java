package app.domain.individuals;

public abstract class Person {
    private String name;
    private String email;

    // constructor methode
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person(String name) {
        this.name = name;
    }

    // setters en getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
