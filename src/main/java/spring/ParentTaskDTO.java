package spring;

import java.io.Serializable;

public class ParentTaskDTO implements Serializable{

	private int parentId;
	
	private String parentTask;
	
	
	public ParentTaskDTO(int parentId, String parentTask) {
		super();
		this.parentId = parentId;
		this.parentTask = parentTask;
	}


	public ParentTaskDTO() {
		super();
	
	}


	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public String getParentTask() {
		return parentTask;
	}


	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	
	
	
	
	
}
