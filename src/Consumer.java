import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class Consumer implements Callable<Integer> {
    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public Integer call() {
        String message;

        try {
            message = queue.poll(1, TimeUnit.SECONDS);
            if (message != null) {
                System.out.println(Thread.currentThread().getName() + " get " + message);
                return 1;
            } else {
                System.out.println(" get nothing");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        return 0;
    }
}