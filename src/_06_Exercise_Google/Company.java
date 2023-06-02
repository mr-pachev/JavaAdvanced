package _06_Exercise_Google;

public class Company {
    private String companyName;
    private String companyDepartment;
    private double salary;

    public Company(String companyName, String companyDepartment, double salary) {
        this.companyName = companyName;
        this.companyDepartment = companyDepartment;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.companyName, this.companyDepartment, this.salary);
    }
}
