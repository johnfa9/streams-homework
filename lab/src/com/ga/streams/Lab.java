package com.ga.streams;

//import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Lab {

    private List<Employee> employees = Arrays.asList(
            new Employee("Bezos, Jeff", LocalDate.of(2004, 4, 2), 68_109.00, "Male"),
            new Employee("Sheryl Sandberg", LocalDate.of(2014, 7, 1), 87_846.00,"Female"),
            new Employee("Buffet, Warren", LocalDate.of(2011, 7, 23), 95_035.00, "Male"),
            new Employee("Susan Wojcick", LocalDate.of(2015, 6, 1), 37_210.00, "Female"),
            new Employee("Zuckerberg, Mark", LocalDate.of(2016, 5, 12), 48_450.00, "Male"),
            new Employee("Brin, Sergey", LocalDate.of(2016, 8, 5), 74_416.00, "Male")
    );

    private <T> void printList(List<T> list) {      //<T> specifies a generic, list can be any type
        list.forEach(employee->System.out.println(employee));

    }

    //@Test
    public void getEmployeesOver50k() {
        //filter
        List<Employee> employees = this.employees.stream()
                .filter(emp -> emp.getSalary() >= 50000)
                .collect(Collectors.toList());
        printList(employees);

    }

    //@Test
    public void getEmployeeNamesHiredAfter2012() {
        //System.out.println(employees.toString());
        List<Employee> employees = this.employees.stream()
                .filter(emp->emp.getHireDate().getYear()>2012)
                .collect(Collectors.toList());
        printList(employees);
    }

    //@Test
    public void getMaxSalary() {
        Double max=this.employees.stream()
        .mapToDouble(emp->emp.getSalary())
                .max()
                .orElse(0);
       System.out.println("Max:" + max);

    }

    //@Test
    public void getMinSalary() {
        double min = this.employees.stream()
                .mapToDouble(emp->emp.getSalary())
                .min()
                .orElse(0);
        System.out.println("Min:" + min);
    }

    //@Test
    public void getAverageSalaries() {
        double averageMale=this.employees.stream()
                .filter(emp->emp.getGender()=="Male")
                .mapToDouble(emp->emp.getSalary())
                .average()
                .orElse(0);
        double averageFemale = this.employees.stream()
                .filter(emp->emp.getGender()=="Female")
                .mapToDouble(emp->emp.getSalary())
                .average()
                .orElse(0);;

        System.out.println("Averages: Male:" + averageMale + " Female:" + averageFemale);

    }

    //@Test
    public void getMaximumPaidEmployee() {
        List<Employee> employees = this.employees.stream()
                .sorted((emp, emp1)->emp1.getSalary().compareTo(emp.getSalary()))
                .collect(Collectors.toList());
        Employee highest=employees.get(0);
        System.out.println(highest);
    }

    public static void main(String[] args) {
        Lab Lab1=new Lab();
        Lab1.getEmployeesOver50k();
        Lab1.getEmployeeNamesHiredAfter2012();
        Lab1.getMaxSalary();
        Lab1.getMinSalary();
        Lab1.getAverageSalaries();
        Lab1.getMaximumPaidEmployee();
    }
}

