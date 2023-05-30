package _06_Exercise_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> departmentMap = new HashMap<>();    //мап с име на отдел и служителите в него
        List<Employee> employeeList = new ArrayList<>();                //списък със служителите на даден отдел
        Employee employee = null;

        for (int i = 1; i <= n; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");

            String name = inputData[0];
            double salary = Double.parseDouble(inputData[1]);
            String position = inputData[2];
            String department = inputData[3];


            if (inputData.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (inputData.length == 5) {
                if (Character.isDigit(inputData[4].charAt(0))) {
                    int age = Integer.parseInt(inputData[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    String email = inputData[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else if (inputData.length == 6) {
                String email = inputData[4];
                int age = Integer.parseInt(inputData[4]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            //проверка дали отдела съществува в мапа
            if (!departmentMap.containsKey(department)) {
                employeeList = new ArrayList<>();
                employeeList.add(employee);
                departmentMap.put(department, employeeList);
            } else {
                employeeList = departmentMap.get(department);   //взимаме списъка със служители на конкретния отдел
                employeeList.add(employee);                     //добавяме обекта-служител към списъка със служители на конкретния отдел
                departmentMap.put(department, employeeList);
            }

        }

        String maxDepartmentAverageSalary = departmentMap.entrySet().stream()
                .max(Comparator.comparing(e -> averageSalary(e.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n", maxDepartmentAverageSalary);

        //взимаме списъка със служителите на отдела с най-висока средна заплата
        List<Employee> employeesMaxSalaryList = departmentMap.get(maxDepartmentAverageSalary);

        //сортеране по заплата (в случая по възходящ ред)
        employeesMaxSalaryList.stream()
                .sorted(Comparator.comparingDouble(emploee -> emploee.getSalary()));

        Collections.reverse(employeesMaxSalaryList); //пренареждаме списъка

        for (Employee employee1 : employeesMaxSalaryList) {
            System.out.println(employee1);
        }

    }

    //изчислява средната заплата на служителите от даден отдел
    public static double averageSalary(List<Employee> employeeList) {
        double avr = 0;

        for (Employee employee : employeeList) {
            avr += employee.getSalary();
        }
        return avr / employeeList.size();
    }
}
