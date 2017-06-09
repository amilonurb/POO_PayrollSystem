package model;

import java.util.Objects;

public abstract class Employee {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double tributos;

    public Employee(String first, String last, String ssn) {
        firstName = first;
        lastName = last;
        socialSecurityNumber = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public double getTributos() {
        return tributos;
    }
    
    public void setTributos(double tributos) {
        this.tributos = tributos;
    }
    
    @Override
    public String toString() {
        return String.format(
                "%s %s\nsocial security number: %s",
                getFirstName(), 
                getLastName(), 
                getSocialSecurityNumber());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + Objects.hashCode(this.socialSecurityNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        final Employee other = (Employee) obj;
        if(!Objects.equals(this.firstName, other.firstName))
            return false;
        if(!Objects.equals(this.lastName, other.lastName))
            return false;
        if(!Objects.equals(this.socialSecurityNumber, other.socialSecurityNumber))
            return false;
        return true;
    }
    
    public abstract double earnings();
    
} // end abstract class Employee