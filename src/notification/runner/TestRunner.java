package notification.runner;

import notification.model.NotificationTask;
import notification.worker.NotificationWorker;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NotificationWorker worker = new NotificationWorker();

		NotificationTask task1 = new NotificationTask("MSG - 1");
		NotificationTask task2 = new NotificationTask("MSG - 2");
		NotificationTask task3 = new NotificationTask("MSG - 3");

		worker.submit(task1);
		worker.submit(task1); // duplicate task, should be ignored
		worker.submit(task2);
		worker.submit(task3);
		worker.submit(task3); // duplicate task, should be ignored

		worker.shutdown();
	}

}
