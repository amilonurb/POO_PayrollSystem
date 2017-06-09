package model;

public class SalariedEmployee extends Employee {

    private double weeklySalary;

    public SalariedEmployee(String first, String last, String ssn, double salary) {
        super(first, last, ssn); // pass to Employee constructor
        setWeeklySalary(salary); // validate and store salary
    }

    public void setWeeklySalary(double salary) {
        weeklySalary = salary < 0.0 ? 0.0 : salary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public double earnings() {
        return (getWeeklySalary() * 4.0) - getTributos();
    }

    @Override
    public String toString() {
        return String.format(
                "salaried employee: %s\n%s: $%,.2f",
                super.toString(), "monthly salary", earnings());
    }
    
} // end class SalariedEmployee