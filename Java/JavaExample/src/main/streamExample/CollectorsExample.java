package main.streamExample;


import main.streamExample.model.Employee;
import main.streamExample.model.EmployeeFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class CollectorsExample {

    public static void main(String[] args) {
        /*averaging example
         * average of first 50 natural number*/
        Double avg =  Stream.iterate(1,(n)->n+1)
                .limit(50)
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("average value is: " + avg);

        /*count number in a stream*/
        System.out.println(Stream.generate(Math::random)
                .limit(100)
                .collect(Collectors.counting())
        );

        /*group by example
        * count number of employee in each department*/
        // creating a map, department as key
        Map<String, List<Employee>> map = EmployeeFactory.employees.stream()
                .collect(groupingBy(Employee::getDepartment));

        //iterating map and printing count for each department
        map.entrySet().stream().forEach(e-> {
            System.out.println(e.getKey()+": number of employee "+e.getValue().size());
        });
    }


}
