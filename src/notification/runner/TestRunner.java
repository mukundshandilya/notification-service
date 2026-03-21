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
		NotificationTask task4 = new NotificationTask("MSG - 4");
		NotificationTask task5 = new NotificationTask("MSG - 5");
		NotificationTask task6 = new NotificationTask("MSG - 6");
		NotificationTask task7 = new NotificationTask("MSG - 7");
		NotificationTask task8 = new NotificationTask("MSG - 8");
		NotificationTask task9 = new NotificationTask("MSG - 9");
		NotificationTask task10 = new NotificationTask("MSG - 10");
		NotificationTask task11 = new NotificationTask("MSG - 11");
		NotificationTask task12 = new NotificationTask("MSG - 12");

		worker.submit(task1);
		worker.submit(task1); // duplicate task, should be ignored
		worker.submit(task2);
		worker.submit(task3);
		worker.submit(task3); // duplicate task, should be ignored
		worker.submit(task4);
		worker.submit(task5);
		worker.submit(task6);
		worker.submit(task7);
		worker.submit(task8);
		worker.submit(task9);
		worker.submit(task10);
		worker.submit(task11);
		worker.submit(task12);

		worker.shutdown();
	}

}
