package notification.worker;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import notification.model.NotificationTask;

public class NotificationWorker {

	private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
	private final Set<String> processedTasks = ConcurrentHashMap.newKeySet();
	private final Set<String> processingTasks = ConcurrentHashMap.newKeySet();

	public void submit(NotificationTask task) {
		executor.submit(() -> process(task));
	}

	private void process(NotificationTask task) {

//		if (processedTasks.contains(task.getTaskId())) {
//			System.out.println("Already processed: " + task.getMessage() + " | TaskId=" + task.getTaskId());
//			return;
//		}

		boolean isNew = processingTasks.add(task.getTaskId());

		if (!isNew) {
			System.out.println("SKIPPED DUPLICATE: " + task.getTaskId());
			return;
		}

		try {
			System.out.println("[Task=" + task.getMessage() + " | TaskId=" + task.getTaskId() + " | Retry="
					+ task.getRetryCount() + " | Thread="
					+ Thread.currentThread().getName() + "]");

			send(task);

			System.out.println("SUCCESS: " + task.getMessage() + " | TaskId=" + task.getTaskId() + " | Thread="
					+ Thread.currentThread().getName());
			processedTasks.add(task.getTaskId());

		} catch (Exception e) {
			System.out.println("FAILED: " + task.getMessage() + " | reason: " + e.getMessage());
			processingTasks.remove(task.getTaskId());
			handleFailure(task);
		}
	}

	private void handleFailure(NotificationTask task) {
		if (task.getRetryCount() < 3) {
			task.incrementRetry();

			int delay = (int) Math.pow(2, task.getRetryCount()); // exponential backoff

			System.out.println("Retrying in " + delay + " sec: " + task.getMessage());

			executor.schedule(() -> process(task), delay, TimeUnit.SECONDS);

		} else {
			moveToDLQ(task);
		}
	}

	private void moveToDLQ(NotificationTask task) {
		System.out.println("DLQ: " + task.getMessage());
		task.setRetryCount(0); // reset retry count for potential future processing
		processingTasks.remove(task.getTaskId());
		handleFailure(task);
	}

	private void send(NotificationTask task) {
		// simulate failure
		if (Math.random() < 0.7) {
			throw new RuntimeException("Random failure");
		}
    }

    public void shutdown() {
		try {
			if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}
    }
}