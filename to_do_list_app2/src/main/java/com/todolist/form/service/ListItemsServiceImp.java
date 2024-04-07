package com.todolist.form.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.form.dao.ListItemsDAO;
import com.todolist.form.entity.ListItems;

@Service
public class ListItemsServiceImp implements ListItemsService {

	@Autowired
	private ListItemsDAO listItemsDAO;

	@Override
	@Transactional
	public List<ListItems> getTasks() {
		return listItemsDAO.getTasks();
	}

	@Override
	@Transactional
	public void addTask(ListItems item) {

		listItemsDAO.addTask(item);

	}

	@Override
	@Transactional
	public ListItems getTask(int id) {
		return listItemsDAO.getTask(id);
	}

	@Override
	@Transactional
	public void deleteTask(int id) {
		listItemsDAO.deleteTask(id);

	}

	@Override
	@Transactional
	public void deleteAllTasks() {

		listItemsDAO.deleteAllTasks();
	}

}
