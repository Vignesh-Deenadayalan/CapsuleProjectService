package spring;

import java.text.ParseException;
import java.util.List;

import org.apache.sling.commons.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@CrossOrigin(origins="*")
@Controller
public class TaskController {
	
	@Autowired
	private ITaskDomain taskDomain;

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	@ResponseBody
public TaskDTO getTaskById(@PathVariable int id) throws JSONException {

		TaskDTO taskDTO=taskDomain.getTaskById(id);
	return taskDTO;

}
	
	@RequestMapping(value = "/view",method = RequestMethod.GET)
	@ResponseBody
public List<TaskDTO> getTaskList() throws JSONException {

		List<TaskDTO> taskDTOList=taskDomain.getTaskList();
	return taskDTOList;

}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
public TaskDTO createTask(@RequestBody TaskDTO taskDTO) throws JSONException, ParseException {
		
		TaskDTO task=taskDomain.createTask(taskDTO);
	return task;
}

	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	@ResponseBody
public TaskDTO modifyTask(@RequestBody TaskDTO taskDTO) throws JSONException, ParseException {

		TaskDTO task=taskDomain.modifyTask(taskDTO);
	return task;

}
	

	@RequestMapping(value = "/delete/id/{id}", method = RequestMethod.DELETE)
	@ResponseBody
public TaskDTO deleteTask(@PathVariable int id) throws JSONException {

		TaskDTO task=taskDomain.deleteTask(id);
	return task;

}
}
