package com.todolist.form.dao;

import java.util.List;

import com.todolist.form.entity.ListItems;

public interface ListItemsDAO {

	List<ListItems> getTasks();

	void addTask(ListItems item);

	ListItems getTask(int id);

	void deleteTask(int id);

	void deleteAllTasks();

}
