package notification.runner;

import notification.worker.NotificationWorker;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NotificationWorker worker = new NotificationWorker();
		worker.sendNotification("Hello, World! - 1");
		worker.sendNotification("Welcome to Java Concurrency! - 2");
		worker.sendNotification("This is a test notification. - 3");
		worker.shutdown();
	}

}
