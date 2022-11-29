public class Certificate {
    private int id;
    private Double rating;
    private Employee employee;

    public Certificate(int id, Double rating, Employee employee) {
        this.id = id;
        this.rating = rating;
        this.employee = employee;
    }

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

}
