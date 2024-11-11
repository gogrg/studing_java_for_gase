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

    public Integer call() {
        for (int i = 0; i < amount; i++) {
            try {
                    //Scanner in = new Scanner(System.in);
                    //System.out.println("Enter some message");
                    //String message = in.nextLine();
                try {
                    queue.put(String.valueOf(i));
                    //System.out.println(Thread.currentThread().getName() + " put in queue " + message);
                } catch (InterruptedException e) {
                    //                try {
                    //                    wait();
                }
                //                } catch (InterruptedException e2) {}
            } catch (InputMismatchException e1) {
                System.out.println("Invalid input");
            }
        }
        return 0;
    }
}
