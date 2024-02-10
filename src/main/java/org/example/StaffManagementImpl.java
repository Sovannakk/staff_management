package org.example;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffManagementImpl implements StaffManagement {
    private static final List<Staff> STAFFS = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final CellStyle CELLSTYLE = new CellStyle(CellStyle.HorizontalAlign.CENTER);
    private static final DecimalFormat DECIMALFORMAT = new DecimalFormat("$#,##0.00");
    private static int incrementId = 3;

    public StaffManagementImpl() {
        STAFFS.add(new Volunteer(1, "Douch", "PVH", 250.00));
        STAFFS.add(new SalaryEmployee(2, "HongMeng", "SR", 250.00, 50.00));
        STAFFS.add(new HourlySalaryEmployee(3, "Lundy", "PP", 5, 10.00));
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("===================== Staff Member =====================");
            System.out.print("""
                    1) Insert Employee
                    2) Display Employee
                    3) Update Employee
                    4) Remove Employee
                    5) Exit
                    """);
            System.out.print("==> Please Choose your options: ");
            int option = SCANNER.nextInt();
            switch (option) {
                case 1 -> insert();
                case 2 -> display();
                case 3 -> update();
                case 4 -> remove();
                case 5 -> {
                    System.out.println("(^-^) Good Bye! (^-^)");
                    System.exit(0);
                }
            }
        }
    }

    @Override
    public void insert() {
        System.out.println("===================== Insert Employee =====================");
        System.out.print("""
                1) Volunteer
                2) SalaryEmployee
                3) HourlySalaryEmployee
                4) Back
                """);
        System.out.print("==> Please Choose your preference: ");
        int preference = SCANNER.nextInt();
        switch (preference) {
            case 1 -> {
                System.out.println("Volunteer");
                Volunteer volunteer = new Volunteer();
                volunteer.insert(SCANNER, ++incrementId);
                STAFFS.add(volunteer);
            }
            case 2 -> {
                System.out.println("SalaryEmployee");
                SalaryEmployee salaryEmployee = new SalaryEmployee();
                salaryEmployee.insert(SCANNER, ++incrementId);
                STAFFS.add(salaryEmployee);
            }
            case 3 -> {
                System.out.println("HourlySalaryEmployee");
                HourlySalaryEmployee hourlySalaryEmployee = new HourlySalaryEmployee();
                hourlySalaryEmployee.insert(SCANNER, ++incrementId);
                STAFFS.add(hourlySalaryEmployee);
            }
        }
        System.out.println("The employee has been successfully inserted.");
    }

    @Override
    public void display() {
        System.out.println("===================== Display Employee =====================");
        Table table = new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        for (int i = 0; i <= 8; i++) {
            if (i == 0 || i == 2) {
                table.setColumnWidth(i, 30, 35);
            } else {
                table.setColumnWidth(i, 15, 20);
            }
        }
        table.addCell("Type", CELLSTYLE);
        table.addCell("ID", CELLSTYLE);
        table.addCell("Name", CELLSTYLE);
        table.addCell("Address", CELLSTYLE);
        table.addCell("Salary", CELLSTYLE);
        table.addCell("Bonus", CELLSTYLE);
        table.addCell("Hour", CELLSTYLE);
        table.addCell("Rate", CELLSTYLE);
        table.addCell("Payment", CELLSTYLE);
        for (Staff staff : STAFFS) {
            if (staff instanceof Volunteer) {
                table.addCell("Volunteer", CELLSTYLE);
                table.addCell(String.valueOf(staff.getId()), CELLSTYLE);
                table.addCell(staff.getName(), CELLSTYLE);
                table.addCell(staff.getAddress(), CELLSTYLE);
                table.addCell(DECIMALFORMAT.format(((Volunteer) staff).getSalary()), CELLSTYLE);
                table.addCell("---", CELLSTYLE);
                table.addCell("---", CELLSTYLE);
                table.addCell("---", CELLSTYLE);
                table.addCell(DECIMALFORMAT.format(staff.payment()), CELLSTYLE);
            } else if (staff instanceof SalaryEmployee) {
                table.addCell("SalaryEmployee", CELLSTYLE);
                table.addCell(String.valueOf(staff.getId()), CELLSTYLE);
                table.addCell(staff.getName(), CELLSTYLE);
                table.addCell(staff.getAddress(), CELLSTYLE);
                table.addCell(DECIMALFORMAT.format(((SalaryEmployee) staff).getSalary()), CELLSTYLE);
                table.addCell(DECIMALFORMAT.format(((SalaryEmployee) staff).getBonus()), CELLSTYLE);
                table.addCell("---", CELLSTYLE);
                table.addCell("---", CELLSTYLE);
                table.addCell(DECIMALFORMAT.format(staff.payment()), CELLSTYLE);
            } else {
                table.addCell("HourlySalaryEmployee", CELLSTYLE);
                table.addCell(String.valueOf(staff.getId()), CELLSTYLE);
                table.addCell(staff.getName(), CELLSTYLE);
                table.addCell(staff.getAddress(), CELLSTYLE);
                table.addCell("---", CELLSTYLE);
                table.addCell("---", CELLSTYLE);
                table.addCell(String.valueOf(((HourlySalaryEmployee) staff).getHour()), CELLSTYLE);
                table.addCell(String.valueOf(((HourlySalaryEmployee) staff).getHour()), CELLSTYLE);
                table.addCell(DECIMALFORMAT.format(staff.payment()), CELLSTYLE);
            }
        }
        System.out.println(table.render());
    }

    @Override
    public void update() {
        System.out.println("===================== Update Employee =====================");
        System.out.print("Enter Id: ");
        int id = SCANNER.nextInt();
        boolean notFound = false;
        for(Staff staff : STAFFS){
            if(staff.getId().equals(id)){
                if (staff instanceof Volunteer){
                    Volunteer volunteer = new Volunteer();
                    volunteer.update(SCANNER, id);
                    STAFFS.set(STAFFS.indexOf(staff), volunteer);
                } else if (staff instanceof SalaryEmployee) {
                    SalaryEmployee salaryEmployee = new SalaryEmployee();
                    salaryEmployee.update(SCANNER, id);
                    STAFFS.set(STAFFS.indexOf(staff), staff);
                } else {
                    HourlySalaryEmployee hourlySalaryEmployee = new HourlySalaryEmployee();
                    hourlySalaryEmployee.update(SCANNER, id);
                    STAFFS.set(STAFFS.indexOf(staff), staff);
                }
                notFound = true;
                System.out.println("The employee has been successfully updated.");
                break;
            }
        }
        if (!notFound){
            System.out.println("The employee id " + id + " has not been founded.");
        }
    }

    @Override
    public void remove() {
        System.out.println("===================== Remove Employee =====================");
        System.out.print("Enter Id: ");
        int id = SCANNER.nextInt();
        boolean notFound = false;
        for(Staff staff : STAFFS){
            if(staff.getId().equals(id)){
                STAFFS.remove(staff);
                notFound = true;
                System.out.println("The employee has been successfully removed.");
                break;
            }
        }
        if (!notFound){
            System.out.println("The employee id " + id + " has not been founded.");
        }
    }
}
