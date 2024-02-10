package org.example;

import java.util.Scanner;

public class SalaryEmployee extends Staff{
    private Double salary;
    private Double bonus;

    public SalaryEmployee() {
    }

    public SalaryEmployee(Integer id, String name, String address, Double salary, Double bonus) {
        super(id, name, address);
        this.salary = salary;
        this.bonus = bonus;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double payment() {
        return salary + bonus;
    }

    @Override
    public void insert(Scanner scanner, int id) {
        super.insert(scanner, id);
        System.out.print("Salary: ");
        salary = scanner.nextDouble();
        System.out.print("Bonus: ");
        bonus = scanner.nextDouble();
        System.out.println("Payment: " + payment());
    }

    @Override
    public void update(Scanner scanner, int id) {
        super.update(scanner, id);
        System.out.print("Salary: ");
        salary = scanner.nextDouble();
        System.out.print("Bonus: ");
        bonus = scanner.nextDouble();
        System.out.println("Payment: " + payment());
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                '}';
    }
}
