package model;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary; // base salary per week

    public BasePlusCommissionEmployee(String first, String last,
            String ssn, double sales, double rate, double salary) {
        super(first, last, ssn, sales, rate);
        setBaseSalary(salary); // validate and store base salary
    }
    
    public void setBaseSalary(double salary) {
        baseSalary = (salary < 0.0) ? 0.0 : salary; // non-negative
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }

    @Override
    public String toString() {
        return String.format("%s %s; %s: $%,.2f",
                "base-salaried", super.toString(),
                "base salary", getBaseSalary());
    }
    
} // end class BasePlusCommissionEmployee