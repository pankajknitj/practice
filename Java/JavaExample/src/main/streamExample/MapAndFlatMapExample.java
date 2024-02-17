package main.streamExample;

import main.streamExample.model.Employee;
import main.streamExample.model.EmployeeFactory;

import java.util.List;

public class MapAndFlatMapExample {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.employees;
        System.out.println("All employees name");
        employees.stream()
                .map(e->e.getName())
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------");
        System.out.println("All unique village");
        employees.stream()
                .flatMap(e->e.getAddresses().stream())
                .flatMap(v->v.getVillages().stream())
                .distinct()
                .forEach(System.out::println);
    }
}
