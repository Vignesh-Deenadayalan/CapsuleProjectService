package spring;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public class ParentTaskDao implements TaskDaoInterface<ParentTask, Integer> {
	 
    private Session currentSession;
     
    private Transaction currentTransaction;
 
    public ParentTaskDao() {
    }
 
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
 
    public void persist(ParentTask entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(ParentTask entity) {
        getCurrentSession().update(entity);
    }
 
    public ParentTask findById(Integer i) {
        ParentTask book = (ParentTask) getCurrentSession().get(ParentTask.class, i);
        return book; 
    }
 
    public void delete(ParentTask entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<ParentTask> findAll() {
        List<ParentTask> books = (List<ParentTask>) getCurrentSession().createQuery("from ParentTask").list();
        return books;
    }
 
    public void deleteAll() {
        List<ParentTask> entityList = findAll();
        for (ParentTask entity : entityList) {
            delete(entity);
        }
    }

    public void persist(Task entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Task entity) {
        getCurrentSession().update(entity);
    }
 
    public Task findSubjectId(Integer i) {
    	Task subject = (Task) getCurrentSession().get(Task.class, i);
        return subject; 
    }
 
    public void delete(Task entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Task> findAllSubjects() {
        List<Task> subjectList = (List<Task>) getCurrentSession().createQuery("from Task").list();
        return subjectList;
    }
 
    public void deleteAllSubjects() {
        List<Task> entityList = findAllSubjects();
        for (Task entity : entityList) {
            delete(entity);
        }
	}

    @SuppressWarnings("unchecked")
    public List<Task> orderAllSubjects() {
        List<Task> subjectList = (List<Task>) getCurrentSession().createQuery("from Subject order by subtitle").list();
        return subjectList;
    }
    
    @SuppressWarnings("unchecked")
    public List<ParentTask> orderAll() {
        List<ParentTask> books = (List<ParentTask>) getCurrentSession().createQuery("from Book order by title").list();
        return books;
    }
    
    @SuppressWarnings("unchecked")
    public List<ParentTask> orderByDate() {
        List<ParentTask> books = (List<ParentTask>) getCurrentSession().createQuery("from Book order by publishDate").list();
        return books;
    }
}
