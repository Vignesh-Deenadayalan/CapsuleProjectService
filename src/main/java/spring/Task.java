package spring;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "task_details")
public class Task {


	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "TASK_ID",unique=true,nullable=false)
	    private int taskId;
	     
	    @Column(name = "PARENT_ID")
	    private int parentId;
	     
	    @Column(name= "TASK")
	    private String task;
	    
	    @Temporal(TemporalType.DATE)
	    @Column(name= "START_DATE")
	    private  Date startDate;
	    
	    @Temporal(TemporalType.DATE)
	    @Column(name= "END_DATE")
	    private  Date endDate;
	    
	    @Column(name= "PRIORITY")
	    private int priority;
	    
	    public Task() {
	    }

	/*
	 * @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER) private
	 * Set<ParentTask> parentTaskSet;
	 */
		

		public Task(int taskId, int parentId, String task, Date startDate, Date endDate, int bookId) {
			super();
			this.taskId = taskId;
			this.parentId = parentId;
			this.task = task;
			this.startDate = startDate;
			this.endDate = endDate;
			this.priority = bookId;
			
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


		public Date getStartDate() {
			return startDate;
		}


		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}


		public Date getEndDate() {
			return endDate;
		}


		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public int getPriority() {
			return priority;
		}


		public void setPriority(int priority) {
			this.priority = priority;
		}


	/*
	 * public Set<ParentTask> getParentTaskSet() { return parentTaskSet; }
	 * 
	 * 
	 * public void setParentTaskSet(Set<ParentTask> parentTaskSet) {
	 * this.parentTaskSet = parentTaskSet; }
	 */

		@Override
		public String toString() {
			return "Task [taskId=" + taskId + ", parentId=" + parentId + ", task=" + task + ", startDate=" + startDate
					+ ", endDate=" + endDate + ", priority=" + priority +  "]";
		}


		


		
	    
}
