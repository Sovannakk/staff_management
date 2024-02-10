package org.example;

import java.util.Scanner;

public class Volunteer extends Staff {
    private Double salary;

    public Volunteer() {
    }

    public Volunteer(Integer id, String name, String address, Double salary) {
        super(id, name, address);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public double payment() {
        return salary;
    }

    @Override
    public void insert(Scanner scanner, int id) {
        super.insert(scanner, id);
        System.out.print("Salary: ");
        salary = scanner.nextDouble();
        System.out.println("Payment: " + payment());
    }

    @Override
    public void update(Scanner scanner, int id) {
        super.update(scanner, id);
        System.out.print("Salary: ");
        salary = scanner.nextDouble();
        System.out.println("Payment: " + payment());
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
