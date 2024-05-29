package Topicstream_Java;


import java.util.*;
import java.util.stream.*;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private int salary;

    public Employee(int id, String name, int age, String department, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}

public class D {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Shiva", 35, "Sales", 30000),
                new Employee(102, "Bala", 42, "HR", 42000),
                new Employee(103, "Ramesh", 23, "Development", 20000),
                new Employee(104, "Devi", 54, "Sales", 48000),
                new Employee(105, "Ramya", 25, "Development", 22000)
        );

        // 1. Print the Employee List Using Stream
        System.out.println("Employee List:");
        employees.forEach(e -> System.out.println(e.getName() + " - " + e.getDepartment() + " - " + e.getSalary()));

        // 2. Find the employees whose salary is greater than 40000
        System.out.println("\nEmployees with salary greater than 40000:");
        employees.stream()
                .filter(e -> e.getSalary() > 40000)
                .forEach(e -> System.out.println(e.getName()));

        // 3. Print the names of Employees in sales department
        System.out.println("\nEmployees in Sales department:");
        employees.stream()
                .filter(e -> e.getDepartment().equals("Sales"))
                .forEach(e -> System.out.println(e.getName()));

        // 4. Print the name of the Highest Salary Employee
        System.out.println("\nHighest Salary Employee:");
        Employee highestPaid = employees.stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
        System.out.println(highestPaid != null ? highestPaid.getName() : "No employee found");

        // 5. Print the name of the Lowest Salary Employee
        System.out.println("\nLowest Salary Employee:");
        Employee lowestPaid = employees.stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
        System.out.println(lowestPaid != null ? lowestPaid.getName() : "No employee found");

        // 6. Remove the duplicate departments / print the unique departments
        System.out.println("\nUnique Departments:");
        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);

        // 7. Sort the employees based on the name
        System.out.println("\nEmployees sorted by name:");
        String sortedNames = employees.stream()
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(sortedNames);

        // 8. Sort the employees based on the name in reverse order
        System.out.println("\nEmployees sorted by name in reverse order:");
        String reverseSortedNames = employees.stream()
                .map(Employee::getName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
        System.out.println(reverseSortedNames);

        // 9. Sort the employees based on the department and name
        System.out.println("\nEmployees sorted by department and name:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getName))
                .forEach(e -> System.out.println(e.getDepartment() + " - " + e.getName()));

        // 10. Print the number of employees in each department
        System.out.println("\nNumber of Employees in Each Department:");
        Map<String, Long> departmentCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        departmentCount.forEach((department, count) -> System.out.println(department + ": " + count));

        // 11. Print the duplicate departments
        System.out.println("\nDuplicate Departments:");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
}