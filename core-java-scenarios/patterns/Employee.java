package patterns;

public abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double salary) { super(name, salary); }
    public double calculateBonus() { return this.salary * 0.20; }
}

class ContractEmployee extends Employee {
    public ContractEmployee(String name, double salary) { super(name, salary); }
    public double calculateBonus() { return 500.0; }
}
