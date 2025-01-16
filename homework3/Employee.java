package dev.m3s.programming2.homework3;

import java.time.LocalDate;

public abstract class Employee extends Person implements Payment{
    
    private int currentYear = LocalDate.now().getYear();
    private String empId;
    private int startYear;
    private Payment payment;


    public Employee(String lname, String fname) {

        super(lname, fname);
        setStartYear(currentYear);
        this.empId = getEmployeeIdString() + getRandomId(2001, 3000);
    }
    
    public String getIdString() {

        return this.empId;
    }

    public int getStartYear() {

        return this.startYear;
    }

    public void setStartYear(final int startYear) {

        if (startYear > 2000 && startYear <= currentYear)
            this.startYear = startYear;
    }

    public Payment getPayment() {
    
        return this.payment;
    }

    public void setPayment(Payment payment) {

        if (payment != null)
            this.payment = payment;
    }

    @Override
    public double calculatePayment() {

        double salary = 0.0;

        if (payment != null) 
            salary = payment.calculatePayment();
        
        return salary;
    }

    protected abstract String getEmployeeIdString();

    @Override
    public String toString() {
        
        return "Employee id: " + empId + "\n" + 
        "       First name: " + getFirstName() + ", Last name: " + getLastName() + "\n" +
        "       Birthdate: " + getBirthDate() + "\n" +
        "       Start year: " + getStartYear() + "\n" +
        "       Salary: " + String.format("%.2f", calculatePayment()).replace(",", ".");
    }
}
