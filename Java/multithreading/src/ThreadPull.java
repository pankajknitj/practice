import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPull {

    static ExecutorService executorService = Executors.newFixedThreadPool(3);
    static ExecutorService singleExecutor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Thread> threads = Arrays.asList(new A("a"),new A("b"),new A("c"),new A("d"),new A("e"));
        for(Thread t : threads){
            executorService.submit(t);
        }
        System.out.println("came outside the look");
        Future<Integer> result = singleExecutor.submit(new CalSum(999999));
        while(!result.isDone());
        System.out.println(result.get());

        executorService.shutdown();
        singleExecutor.shutdown();
    }


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
