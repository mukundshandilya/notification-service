package notification.model;

import java.util.UUID;

public class NotificationTask {

	private String message;
	private int retryCount;
	private final String taskId;

	public NotificationTask(String message) {
		this.message = message;
		this.retryCount = 0;
		this.taskId = UUID.randomUUID().toString();
	}

	public String getMessage() {
		return message;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void incrementRetry() {
		this.retryCount++;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setRetryCount(int i) {
		this.retryCount = i;
	}

}
