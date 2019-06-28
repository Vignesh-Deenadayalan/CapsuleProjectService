package spring;

import java.text.ParseException;
import java.util.List;

import org.apache.sling.commons.json.JSONException;

public interface ITaskDomain {

	public TaskDTO getTaskById(int id) throws JSONException;
	
	public List<TaskDTO> getTaskList() throws JSONException;
	
	public TaskDTO createTask( TaskDTO bookDTO) throws JSONException, ParseException;
	
	public TaskDTO modifyTask(TaskDTO bookDTO) throws JSONException, ParseException;
	
	public TaskDTO deleteTask( int id) throws JSONException;
}
