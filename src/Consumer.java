import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class Consumer implements Callable<Integer> {
    private final BlockingQueue<String> queue;
    //String name;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
        //this.name = Thread.currentThread().getName();
    }

    public Integer call() {
        String message;

        try {
            message = queue.poll(1, TimeUnit.SECONDS);
            if (message != null) {
                System.out.println(Thread.currentThread().getName() + " get " + message);
                return 1;
            } else {
                System.out.println(Thread.currentThread().getName() + " get nothing");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread" + Thread.currentThread().getName() + "interrupted");
        }
        return 0;
    }
}