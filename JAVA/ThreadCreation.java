// Exercise 26: Thread Creation
// Objective: Implement multithreading.
public class ThreadCreation {

    static class PrinterThread extends Thread {
        private final String message;

        PrinterThread(String name, String message) {
            super(name);
            this.message = message;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(getName() + ": " + message + " (" + i + ")");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new PrinterThread("Thread-A", "Hello from A");

        // Approach 2: implement Runnable.
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread-B: Hello from B (" + i + ")");
            }
        }, "Thread-B");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Both threads finished.");
    }
}
