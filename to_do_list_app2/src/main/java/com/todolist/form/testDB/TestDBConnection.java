package com.todolist.form.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBConnection
 */
@WebServlet("/TestDBConnection")
public class TestDBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = "springstudent";
		String passWord = "springstudent";
		String jdbcurl = "mysql://localhost:3306/to_do_list?useSSL=false&serverTimezone=UTC";

		String driver = "com.mysql.cj.jdbc.Driver";

		try {

			PrintWriter writer = response.getWriter();

			writer.println("Connecting to data base" + jdbcurl);

			Class.forName(driver);

			Connection connection = DriverManager.getConnection(jdbcurl, userName, passWord);

			writer.println("Connection Success!");

			connection.close();

		} catch (Exception e) {

			e.printStackTrace();

			throw new ServletException(e);

		}

	}

}
