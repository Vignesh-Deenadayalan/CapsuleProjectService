package spring;

import java.io.Serializable;


public class TaskDTO implements Serializable{

	private int taskId;
	
	private int parentId;
	
	private String task;
	
	private String startDate;
	
	private String endDate;
	
	private int priority;
	
	private String parentTask;
	
	private String message;
	
	
	public TaskDTO() {
		super();
	}

	public TaskDTO(int taskId, int parentId, String task, String startDate, String endDate, int priority,
			String parentTask) {
		super();
		this.taskId = taskId;
		this.parentId = parentId;
		this.task = task;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.parentTask = parentTask;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}


	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	
	
}
