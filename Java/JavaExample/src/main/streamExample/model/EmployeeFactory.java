package main.streamExample.model;

import java.util.Arrays;
import java.util.List;

public class EmployeeFactory {
    private static List<Address> addr1 = Arrays.asList(
            new Address("goreyakothi",Arrays.asList("chandpur","meghwar","sultanpur")),
            new Address("barhariya",Arrays.asList("bishunpura","bhopatpur"))
    );
    private static List<Address> addr2 = Arrays.asList(
            new Address("siwan",Arrays.asList("chandpur1","meghwar1","sultanpur1")),
            new Address("gopalganj",Arrays.asList("bishunpura1","bhopatpur1"))
    );
    private static List<Address> addr3 = Arrays.asList(
            new Address("patna",Arrays.asList("chandpur2","meghwar2","sultanpur2")),
            new Address("chapra",Arrays.asList("bishunpura2","bhopatpur2"))
    );
   public static List<Employee> employees = Arrays.asList(
            new Employee("pankaj",26,"Tech",50000,addr1),
            new Employee("Chinky",28,"Tech-Operation",55000,addr2),
            new Employee("Abhishek",25,"Hr",40000,addr3)
    );
}
