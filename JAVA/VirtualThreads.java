// Exercise 40: Virtual Threads (Java 21)
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreads {

    static final int COUNT = 100_000;

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();

        long start = System.nanoTime();
        Thread[] threads = new Thread[COUNT];

        for (int i = 0; i < COUNT; i++) {
            final int id = i;
            
            threads[i] = Thread.startVirtualThread(() -> {
                counter.incrementAndGet();
                if (id % 20_000 == 0) {
                    System.out.println("Virtual thread " + id + " running on " + Thread.currentThread());
                }
            });
        }
        
        
        for (Thread t : threads) {
            t.join();
        }

        long elapsedMs = (System.nanoTime() - start) / 1_000_000;
        System.out.println("\nCompleted " + counter.get() + " virtual threads in " + elapsedMs + " ms.");
        System.out.println("Launching this many platform (OS) threads would typically exhaust memory;");
        System.out.println("virtual threads are cheap because many share a small pool of carrier threads.");
    }
}
