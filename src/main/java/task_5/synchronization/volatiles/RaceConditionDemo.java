package task_5.synchronization.volatiles;

public class RaceConditionDemo {
    private static boolean running;

    public static void main(String[] args) {
        var t1 = new Thread(() -> {
            while (!running) {}
            System.out.println("topjava.ru");
        });

        var t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            running = true;
            System.out.println("I love");
        });

        t1.start();
        t2.start();
    }
}
