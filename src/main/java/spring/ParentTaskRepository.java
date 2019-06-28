package spring;

import java.util.List;

public class ParentTaskRepository {

	private static ParentTaskDao parentTaskDao;
	 
    public ParentTaskRepository() {
        parentTaskDao = new ParentTaskDao();
    }
 
    public void persist(ParentTask entity) {
        parentTaskDao.openCurrentSessionwithTransaction();
        parentTaskDao.persist(entity);
        parentTaskDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(ParentTask entity) {
        parentTaskDao.openCurrentSessionwithTransaction();
        parentTaskDao.update(entity);
        parentTaskDao.closeCurrentSessionwithTransaction();
    }
 
    public ParentTask findById(int i) {
        parentTaskDao.openCurrentSession();
        ParentTask book = parentTaskDao.findById(i);
        parentTaskDao.closeCurrentSession();
        return book;
    }
 
    public void delete(int id) {
        parentTaskDao.openCurrentSessionwithTransaction();
        ParentTask book = parentTaskDao.findById(id);
        parentTaskDao.delete(book);
        parentTaskDao.closeCurrentSessionwithTransaction();
    }
 
    public List<ParentTask> findAll() {
        parentTaskDao.openCurrentSession();
        List<ParentTask> books = parentTaskDao.findAll();
        parentTaskDao.closeCurrentSession();
        return books;
    }
 
    public void deleteAll() {
        parentTaskDao.openCurrentSessionwithTransaction();
        parentTaskDao.deleteAll();
        parentTaskDao.closeCurrentSessionwithTransaction();
    }
 
    public ParentTaskDao bookDao() {
        return parentTaskDao;
    }

    public List<ParentTask> orderAll() {
        parentTaskDao.openCurrentSession();
        List<ParentTask> books = parentTaskDao.orderAll();
        parentTaskDao.closeCurrentSession();
        return books;
    }
    
    public List<ParentTask> orderByDate() {
        parentTaskDao.openCurrentSession();
        List<ParentTask> books = parentTaskDao.orderByDate();
        parentTaskDao.closeCurrentSession();
        return books;
    }
}
