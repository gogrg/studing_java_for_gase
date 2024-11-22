import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class Consumer implements Callable<Integer> {
    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public Integer call() {
        String name = Thread.currentThread().getName();
        String message;

        try {
            message = queue.poll(1, TimeUnit.SECONDS);
            if (message != null) {
                System.out.println(name + " get " + message);
                return 1;
            } else {
                System.out.println(name + " get nothing");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread" + name + "interrupted");
        }
        return 0;
    }
}