import java.io.*;

class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String msg) { super(msg); }
}

class Employee {
    protected double baseSalary;
    public Employee(double baseSalary) throws InvalidSalaryException {
        if (baseSalary <= 0) throw new InvalidSalaryException("Salary must be positive!");
        this.baseSalary = baseSalary;
    }
    public double calculateSalary() { return baseSalary; }
}

class Manager extends Employee {
    private double bonus;
    public Manager(double baseSalary, double bonus) throws InvalidSalaryException {
        super(baseSalary);
        if (bonus < 0) throw new InvalidSalaryException("Bonus cannot be negative!");
        this.bonus = bonus;
    }
    public double calculateSalary() { return super.calculateSalary() + bonus; }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        try (PrintWriter log = new PrintWriter(new FileWriter("EmployeeDemo.log", true))) {
            try {
                Employee e = new Employee(30000);
                Manager m = new Manager(50000, 10000);

                String empSalary = "Employee Salary: " + e.calculateSalary();
                String manSalary = "Manager Salary: " + m.calculateSalary();

                System.out.println(empSalary);
                System.out.println(manSalary);

                log.println(empSalary);
                log.println(manSalary);
            } catch (InvalidSalaryException e) {
                System.out.println("Error: " + e.getMessage());
                log.println("Error: " + e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}