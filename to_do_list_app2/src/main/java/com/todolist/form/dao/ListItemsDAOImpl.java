package com.todolist.form.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todolist.form.entity.ListItems;

@Repository
public class ListItemsDAOImpl implements ListItemsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ListItems> getTasks() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<ListItems> theQuery = currentSession.createQuery("from ListItems", ListItems.class);

		List<ListItems> tasks = theQuery.getResultList();

		return tasks;
	}

	@Override
	public void addTask(ListItems item) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(item);
		;

	}

	@Override
	public ListItems getTask(int id) {

		Session currentSession = sessionFactory.getCurrentSession();

		ListItems item = currentSession.get(ListItems.class, id);

		currentSession.saveOrUpdate(item);

		return item;
	}

	@Override
	public void deleteTask(int id) {

		Session currentSession = sessionFactory.getCurrentSession();

		ListItems item = currentSession.get(ListItems.class, id);

		currentSession.delete(item);

	}

	@Override
	public void deleteAllTasks() {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.createQuery("delete from ListItems").executeUpdate();
	}

}
