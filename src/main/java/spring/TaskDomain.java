package spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.sling.commons.json.JSONException;
import org.springframework.stereotype.Component;

@Component
public class TaskDomain implements ITaskDomain{

	public TaskDTO getTaskById(int id) throws JSONException {
		TaskRepository taskService = new TaskRepository();
		ParentTaskRepository parentTaskService = new ParentTaskRepository();
		Task task =new Task();
		task=taskService.findById(id);
		TaskDTO taskDTO=new TaskDTO();
		taskDTO.setTaskId(task.getTaskId());
		taskDTO.setTask(task.getTask());
		taskDTO.setStartDate(convertDateFormat(task.getStartDate()));
		taskDTO.setEndDate(convertDateFormat(task.getEndDate()));
		taskDTO.setPriority(task.getPriority());
		taskDTO.setParentId(task.getParentId());
		ParentTask parentTask=parentTaskService.findById(task.getParentId());
		taskDTO.setParentTask(parentTask.getParentTask());
		taskDTO.setMessage("Task Retrieved successfully");
		return taskDTO;
	}

	public List<TaskDTO> getTaskList() throws JSONException {
		TaskRepository taskService = new TaskRepository();
		ParentTaskRepository parentTaskService = new ParentTaskRepository();
		List<TaskDTO> list=new ArrayList<TaskDTO>();
		List<Task> tasks = taskService.findAll();
		System.out.println("Tasks added are :");
		for (Task task : tasks) {
			TaskDTO taskDTO=new TaskDTO();
			taskDTO.setTaskId(task.getTaskId());
			taskDTO.setTask(task.getTask());
			taskDTO.setStartDate(convertDateFormat(task.getStartDate()));
			taskDTO.setEndDate(convertDateFormat(task.getEndDate()));
			taskDTO.setPriority(task.getPriority());
			taskDTO.setParentId(task.getParentId());
			ParentTask parentTask=parentTaskService.findById(taskDTO.getParentId());
			taskDTO.setParentTask(parentTask.getParentTask());
			list.add(taskDTO);
		}
		return list;
	}

	public TaskDTO createTask(TaskDTO taskDTO) throws JSONException, ParseException {
		TaskRepository taskService = new TaskRepository();
		ParentTaskRepository parentTaskService = new ParentTaskRepository();
		Task task =new Task();
		ParentTask parentTask =new ParentTask();
		parentTask.setParentTask(taskDTO.getParentTask());
		parentTaskService.persist(parentTask);
		task.setTask(taskDTO.getTask());
		task.setStartDate(formatetoDate(formateDate(taskDTO.getStartDate())));
		task.setEndDate(formatetoDate(formateDate(taskDTO.getEndDate())));
		task.setPriority(taskDTO.getPriority());
		task.setParentId(parentTask.getParentId());
		taskService.persist(task);
		taskDTO.setStartDate(convertDateFormat(task.getStartDate()));
		taskDTO.setEndDate(convertDateFormat(task.getEndDate()));
		taskDTO.setTaskId(task.getTaskId());
		taskDTO.setParentId(task.getParentId());
		taskDTO.setMessage("Create successful");
		return taskDTO;
	}

	public TaskDTO modifyTask(TaskDTO taskDTO) throws JSONException, ParseException {
		
		TaskRepository taskService = new TaskRepository();
		ParentTaskRepository parentTaskService = new ParentTaskRepository();
		Task task =new Task();
		ParentTask parentTask =new ParentTask();
		task=taskService.findById(taskDTO.getTaskId());
		task.setTask(taskDTO.getTask());
		task.setStartDate(formatetoDate(formateDate(taskDTO.getStartDate())));
		task.setEndDate(formatetoDate(formateDate(taskDTO.getEndDate())));
		task.setPriority(taskDTO.getPriority());
		task.setParentId(taskDTO.getParentId());
		taskService.update(task);
		parentTask=parentTaskService.findById(taskDTO.getParentId());
		parentTask.setParentTask(taskDTO.getParentTask());
		parentTaskService.update(parentTask);
		task=taskService.findById(taskDTO.getTaskId());
		taskDTO.setTaskId(task.getTaskId());
		taskDTO.setTask(task.getTask());
		taskDTO.setStartDate(convertDateFormat(task.getStartDate()));
		taskDTO.setEndDate(convertDateFormat(task.getEndDate()));
		taskDTO.setPriority(task.getPriority());
		taskDTO.setParentId(task.getParentId());
		taskDTO.setParentTask(parentTask.getParentTask());
		taskDTO.setMessage("Modify successful");
		return taskDTO;
	}
	
	public static String formateDate(String date) throws ParseException {
		SimpleDateFormat sdfSource = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd");
		String finalDate="";
		finalDate=sdfDestination.format(sdfSource.parse(date));
		return finalDate;
	}
	
	public static String convertDateFormat(Object date) {
		
		String dte = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if (null!=date && !date.toString().trim().equals("")) {
			dte = dateFormat.format(date).trim();
		}

		return dte;
	}
	
	public static Date formatetoDate(String date) throws ParseException {
		if (null != date && !date.isEmpty()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if(null != dateFormat){
				return dateFormat.parse(date);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public TaskDTO deleteTask(int id) throws JSONException {
		TaskRepository taskService = new TaskRepository();
		TaskDTO taskDTO=new TaskDTO();
		Task task=taskService.findById(id);

		taskService.delete(id);
		taskDTO.setTaskId(task.getTaskId());
		taskDTO.setTask(task.getTask());
		taskDTO.setStartDate(convertDateFormat(task.getStartDate()));
		taskDTO.setEndDate(convertDateFormat(task.getEndDate()));
		taskDTO.setPriority(task.getPriority());
		taskDTO.setParentId(task.getParentId());
		taskDTO.setMessage("Delete successful for " + task.getTask());
	
		return taskDTO;
	}

	

}
