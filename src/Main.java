import java.util.concurrent.*;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        final int AMOUNT_MESSAGE = 20
                ;

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

        FutureTask<Integer> producer = new FutureTask<>(new Producer(queue, AMOUNT_MESSAGE));
        new Thread(producer).start();

        ThreadFactory namedThreadFactory = new ThreadFactory() {
            private int count = 0;

            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("Consumer " + count);
                count++;

                return thread;
            }
        };

        try(ExecutorService pool = Executors.newFixedThreadPool(10, namedThreadFactory)){
            while (true) {
                FutureTask<Integer> task = new FutureTask<>(new Consumer(queue));
                pool.submit(task);
                try{
                    int answer = task.get();
                    if (answer == 0){
                        pool.shutdownNow();
                        break;
                    }
                }
                catch (InterruptedException | ExecutionException e) {
                    System.out.println("Task interrupted");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Try highlight pool threads failed");
            System.out.println(e.getMessage());
        }

    }
}