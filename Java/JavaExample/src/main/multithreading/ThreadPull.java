package main.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
/* Example of Thread pull*/
public class ThreadPull {

    /* ThreadPull of 3 threads*/
    static ExecutorService executorService = Executors.newFixedThreadPool(3);
    /* A single Threaded pull to execute a callable*/
    static ExecutorService singleExecutor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /* Thread List*/
        List<Thread> threads = Arrays.asList(new A("a"),new A("b"),new A("c"),new A("d"),new A("e"));
        /*Executing each thread using threadpull*/
        for(Thread t : threads){
            /*Submit() can accept both runnable and callable but not execute()*/
            executorService.submit(t);
        }
        System.out.println("came outside the look");
        /* Passing a callable and storing result*/
        Future<Integer> result = singleExecutor.submit(new CalSum(999999));
        /* checking calculation is done or not*/
        while(!result.isDone());
        System.out.println(result.get());
        /* tells that when execution finishes then shutdown
        * After this pull not accept any further submissions
        * .shutdownNow() tells that only finish the executing thread and interrupt the Thread present in queue*/
        executorService.shutdown();
        singleExecutor.shutdown();


    }


    /*A simple Thread*/
    static class A extends Thread{
        String name;
        A(String n){
            name = n;
        }
        public void run(){
            System.out.println("inside "+name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /* A Thread made up of callable which returns calculated value*/
    static class CalSum implements Callable {
        int num;
        CalSum(int n){
            num = n;
        }
        @Override
        public Object call() throws Exception {
            int sum = 0;
            while(num>0){
                sum += num%10;
                num /= 10;
            }
            Thread.sleep(2000);
            return sum;
        }
    }
}
