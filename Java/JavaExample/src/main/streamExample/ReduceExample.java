package main.streamExample;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(list.stream().reduce(0,(a,b)->a+b));
        System.out.println(list.stream().reduce((a,b)->a+b));
        System.out.println(list.stream().reduce(Integer::sum));
    }


}
