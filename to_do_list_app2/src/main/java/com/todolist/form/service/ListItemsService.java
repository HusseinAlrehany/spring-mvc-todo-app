package com.todolist.form.service;

import java.util.List;

import com.todolist.form.entity.ListItems;

public interface ListItemsService {

	List<ListItems> getTasks();

	void addTask(ListItems item);

	ListItems getTask(int id);

	void deleteTask(int id);

	void deleteAllTasks();

}
