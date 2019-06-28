package spring;

import java.util.List;

public class TaskRepository {

	private static ParentTaskDao taskDao;
	
	
	
	 public TaskRepository() {
	        taskDao = new ParentTaskDao();
	    }
	 public void persist(Task entity) {
	        taskDao.openCurrentSessionwithTransaction();
	        taskDao.persist(entity);
	        taskDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public void update(Task entity) {
	        taskDao.openCurrentSessionwithTransaction();
	        taskDao.update(entity);
	        taskDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public Task findById(int i) {
	        taskDao.openCurrentSession();
	        Task subject = taskDao.findSubjectId(i);
	        taskDao.closeCurrentSession();
	        return subject;
	    }
	 
	    public void delete(int id) {
	        taskDao.openCurrentSessionwithTransaction();
	        Task subject = taskDao.findSubjectId(id);
	        taskDao.delete(subject);
	        taskDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public List<Task> findAll() {
	    	taskDao.openCurrentSession();
	        List<Task> subjects = taskDao.findAllSubjects();
	        taskDao.closeCurrentSession();
	        return subjects;
	    }
	 
	    public void deleteAll() {
	        taskDao.openCurrentSessionwithTransaction();
	        taskDao.deleteAll();
	        taskDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public ParentTaskDao bookDao() {
	        return taskDao;
	    }

	    public List<Task> orderAll() {
	        taskDao.openCurrentSession();
	        List<Task> subjects = taskDao.orderAllSubjects();
	        taskDao.closeCurrentSession();
	        return subjects;
	    }
}
