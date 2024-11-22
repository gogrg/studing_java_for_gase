import java.util.InputMismatchException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

class Producer implements Callable<Integer> {
    private final BlockingQueue<String> queue;
    private final int amount;

    public Producer(BlockingQueue<String> queue, int amount) {
        this.queue = queue;
        this.amount = amount;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < amount; i++) {
            try {
                try {
                    queue.put(String.valueOf(i));
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            } catch (InputMismatchException e1) {
                System.out.println("Invalid input");
            }
        }
        return 0;
    }
}
