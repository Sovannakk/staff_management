package org.example;

import java.util.Scanner;

public abstract class Staff {
    protected Integer id;
    protected String name;
    protected String address;

    public abstract double payment();

    public Staff() {
    }

    public Staff(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void insert(Scanner scanner, int id){
        System.out.println("ID: " + id);
        this.id = id;
        System.out.print("Name: ");
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("Address: ");
        address = scanner.nextLine();
    }

    public void update(Scanner scanner, int id){
        this.id = id;
        System.out.print("Name: ");
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("Address: ");
        address = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
