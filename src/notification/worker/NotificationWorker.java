package notification.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationWorker {

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public void sendNotification(String message) {
        executor.submit(() -> {
            System.out.println("Processing notification: " + message +
                    " by " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000); // simulate sending
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}