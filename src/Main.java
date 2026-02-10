import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee{
    private String name;
    private int age;
    private String gender;
    private int salary;
    private String designation;
    private String department;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }
    public void setSalary(int sal){
        this.salary=sal;
    }

    public Employee(String name, int age, String gender, int salary, String designation, String department) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.designation = designation;
        this.department = department;
    }
    public String toString() {
        return name + " " + age + " " + salary + " " + designation;
    }
}
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<Employee> l=new ArrayList<Employee>();
        l.add(new Employee("Amit", 45, "Male", 90000, "Manager", "HR"));
        l.add(new Employee("Neha", 32, "Female", 55000, "Developer", "IT"));
        l.add(new Employee("Rahul", 38, "Male", 70000, "Lead", "IT"));
        l.add(new Employee("Priya", 29, "Female", 48000, "Tester", "QA"));
        l.add(new Employee("Suresh", 50, "Male", 95000, "Manager", "Finance"));
        l.add(new Employee("Anita", 41, "Female", 80000, "Architect", "IT"));
        l.add(new Employee("Karan", 26, "Male", 40000, "Developer", "IT"));
        l.add(new Employee("Meena", 35, "Female", 60000, "HR Executive", "HR"));
        l.add(new Employee("Rohit", 44, "Male", 85000, "Manager", "Operations"));
        l.add(new Employee("Divya", 31, "Female", 52000, "Analyst", "Finance"));

        l.add(new Employee("Vikram", 39, "Male", 72000, "Lead", "QA"));
        l.add(new Employee("Pooja", 28, "Female", 45000, "Designer", "UI"));
        l.add(new Employee("Arjun", 47, "Male", 88000, "Manager", "IT"));
        l.add(new Employee("Sneha", 34, "Female", 58000, "Developer", "IT"));
        l.add(new Employee("Mahesh", 52, "Male", 98000, "Director", "Management"));
        l.add(new Employee("Kavya", 27, "Female", 42000, "Trainee", "HR"));
        l.add(new Employee("Nikhil", 36, "Male", 65000, "Engineer", "Operations"));
        l.add(new Employee("Swathi", 42, "Female", 78000, "Consultant", "Finance"));
        l.add(new Employee("Ajay", 30, "Male", 50000, "Support", "IT"));
        l.add(new Employee("Lakshmi", 46, "Female", 82000, "Manager", "QA"));


        Employee highestPaid=l.stream().max(Comparator.comparingInt(Employee::getSalary)).orElse(null);
        System.out.println(highestPaid.getName() + " " + highestPaid.getSalary());
        System.out.println("----------------------------------");
//        Map<String, Long> m1=l.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
//        System.out.println(m1);
        Map<Boolean, Long> m1=l.stream().collect(Collectors.partitioningBy(e->e.getGender().equals("Male"),Collectors.counting())); //partitioning by is better for two classes
        System.out.println(m1);
        System.out.println("----------------------------------");
        Map<String,Integer> m2=l.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingInt(Employee::getSalary)));
        System.out.println(m2);
        System.out.println("----------------------------------");
        List<Employee> top5Senior =
                l.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).limit(5).collect(Collectors.toList());

        top5Senior.forEach(e ->
                System.out.println(e.getName() + " " + e.getAge())
        );
        System.out.println("----------------------------------");
        Predicate<Employee> p1=e->e.getDesignation().equals("Manager");
        List<Employee> managers=l.stream().filter(p1).collect(Collectors.toList());
        managers.forEach(e-> System.out.println(e.getName()));

        l.stream().filter(p1.negate()).forEach(e -> {
            e.setSalary((int)(e.getSalary() * 1.2));
            System.out.println(e.getName() + " " + e.getSalary());
        });
        System.out.println("----------------------------------");
        long totalEmployees = l.size();
        System.out.println("\nTotal Number of Employees: " + totalEmployees);
    }
}