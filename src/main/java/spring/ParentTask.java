package spring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parent_task")
public class ParentTask {

	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "PARENT_ID",unique=true,nullable=false)
	    private int parentId;
	     
	    @Column(name = "PARENT_TASK")
	    private String parentTask;
	     
	    
	     
	    public ParentTask() {
	    }

		public ParentTask(int parentId, String parentTask) {
			super();
			this.parentId = parentId;
			this.parentTask = parentTask;
			
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

		@Override
		public String toString() {
			return "ParentTask [parentId=" + parentId + ", parentTask=" + parentTask + "]";
		}

		
		
	    
	    
}
