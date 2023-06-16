package Exams_Cafe_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if (capacity > employees.size()){
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        boolean isRemoved = false;

        for (Employee employee : employees){
            if (employee.getName().equals(name)){
                employees.remove(employee);
                return isRemoved = true;
            }
        }
        return isRemoved;
    }

    public Employee getOldestEmployee(){
        return this.employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees){
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();

        builder.append("Employees working at Cafe ").append(name);

        for (Employee employee: employees){
            builder.append(System.lineSeparator()).append(employee);
        }
        return builder.toString();
    }
}
