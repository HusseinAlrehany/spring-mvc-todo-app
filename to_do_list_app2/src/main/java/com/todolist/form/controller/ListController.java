package com.todolist.form.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.todolist.form.entity.ListItems;
import com.todolist.form.service.ListItemsService;

@Controller
@RequestMapping("/todolist")
public class ListController {

	@Autowired
	private ListItemsService listItemsService;

	// for removing leading and trailing white spaces
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		//FOR VALIDATING THAT NO SPACES ACCEPTED
		StringTrimmerEditor stringTrimmerEditor = 
				new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
		//FOR VALIDATING THAT ONLY DATE IS ACCEPTABLE
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
		
		

	}

	@GetMapping("/viewList")
	public String showTodoList(Model theModel) {

		// get the tasks from the service
		List<ListItems> tasks = listItemsService.getTasks();

		// set the tasks as a model
		theModel.addAttribute("tasks", tasks);

		return "todolist-form";

	}

	@GetMapping("/addnewtaskform")
	public String addNewTaskForm(Model theModel) {

		ListItems item = new ListItems();

		theModel.addAttribute("tasks", item);

		return "addnewtask";

	}

	@PostMapping("/addnewtask")
	public String addNewTask(@Valid @ModelAttribute("tasks") ListItems item, BindingResult result) {

		if (result.hasErrors()) {
			return "addnewtask";
		}

		listItemsService.addTask(item);

		return "redirect:/todolist/viewList";

	}

	@GetMapping("/showUpdateForm")
	public String showFormForEditTask(@RequestParam("taskId") int id, Model theModel) {

		// GET THE TASK FROM THE SERVICE

		ListItems item = listItemsService.getTask(id);

		// SET THE TASK AS MODEL TO REPOULATE THE FORM
		theModel.addAttribute("tasks", item);

		// SENT IT OVER TO REPOPULATE THE FORM

		return "addnewtask";

	}

	@GetMapping("/deleteTask")
	public String deleteTask(@RequestParam("taskId") int id) {

		listItemsService.deleteTask(id);

		return "redirect:/todolist/viewList";

	}

	@RequestMapping(value = "/deleteAllTasks", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteAllTasks() {

		listItemsService.deleteAllTasks();

		return "redirect:/todolist/viewList";

	}

}
