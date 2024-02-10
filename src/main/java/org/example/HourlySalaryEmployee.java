package org.example;

import java.util.Scanner;

public class HourlySalaryEmployee extends Staff {
    private Integer hour;
    private Double rate;

    public HourlySalaryEmployee() {
    }

    public HourlySalaryEmployee(Integer id, String name, String address, Integer hour, Double rate) {
        super(id, name, address);
        this.hour = hour;
        this.rate = rate;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public double payment() {
        return hour * rate;
    }

    @Override
    public void insert(Scanner scanner, int id) {
        super.insert(scanner, id);
        System.out.print("Hour: ");
        hour = scanner.nextInt();
        System.out.print("Bonus: ");
        rate = scanner.nextDouble();
        System.out.println("Payment: " + payment());
    }

    @Override
    public void update(Scanner scanner, int id) {
        super.update(scanner, id);
        System.out.print("Hour: ");
        hour = scanner.nextInt();
        System.out.print("Bonus: ");
        rate = scanner.nextDouble();
        System.out.println("Payment: " + payment());
    }

    @Override
    public String toString() {
        return "HourlySalaryEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", hour=" + hour +
                ", rate=" + rate +
                '}';
    }
}
