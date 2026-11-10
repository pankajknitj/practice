package main.streamExample;

import main.streamExample.model.Employee;
import main.streamExample.model.EmployeeFactory;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewQuestions {
    public static void main(String[] args) {
        //1. Find the second-highest number in a list.
        List<Integer> numbers = Arrays.asList(3, 5,5,3, 1,1, 4, 2);
        int secondHighest = numbers.stream().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println("Second highest number: " + secondHighest);

        //2. Find duplicate elements in a list.
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicate = numbers.stream().filter(n -> !set.add(n)).distinct().toList();
        System.out.println("Duplicate elements: " + duplicate);

        //3. Find the frequency of each character in a string.
        String str = "Mastering Java Streams";
        Map<Character,Long> freq = str.chars().mapToObj(c -> (char)c).toList().stream()
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Char Freq" + freq);

        //4. Find the first non-repeating character.
        char firstNonRepeating = str.toLowerCase().chars().mapToObj(c -> (char)c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap<Character,Long>::new,Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue()==1)
                .limit(1)
                .map(Map.Entry::getKey)
                .findFirst().orElse('-');
        System.out.println("first repeating char: " + firstNonRepeating);

        //5. Find the highest-paid employee in each department.
        List<Employee> employees = EmployeeFactory.employees;
        Map<String, Employee> depHighestPaudEmpMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                                (Optional<Employee> emp) -> emp.orElse(null)
                        )));

        //another approach
//        depHighestPaudEmpMap = employees.stream()
//                .collect(Collectors.toMap(Employee::getDepartment,
//                        Function.identity(),
//                        BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary))));


        System.out.println("Highest salary department wise: " + depHighestPaudEmpMap);

        //6. Find the second-highest salary in each department.
        Map<String, Double> depHighestSecondSalaryMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(),l->l.stream().map(Employee::getSalary).sorted(Collections.reverseOrder()).skip(1).findFirst().orElse(0.00))));

        System.out.println("Second Highest Salary department wise: " + depHighestSecondSalaryMap);

    }
}
