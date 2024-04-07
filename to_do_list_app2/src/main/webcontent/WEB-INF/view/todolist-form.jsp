<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<header>

	<title>To Do List Application</title>


	<!-- reference our css -->

	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">



</header>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>To do List Application</h2>


		</div>



	</div>

	<div id="container">

		<div id="content">

			<!-- ADD NEW TASK BUTTON -->
			<input type="button" value="+Add New Task"
				onClick="window.location.href='addnewtaskform';return false"
				class="add-button" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="Clear Tasks"
				onClick="window.location.href='http://localhost:8080/to_do_list_app/todolist/deleteAllTasks';return false;" class="add-button"/>



			<table>

				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Date</th>
					<th>Status</th>
					<th>Action</th>

					<!-- LOOPING OVER TO PRINT THE TASKS -->

					<c:forEach var="tempItem" items="${tasks}">

						<!-- CONSTRUCT UPDATE LINK WITH TASK ID -->
						<c:url var="editLink" value="/todolist/showUpdateForm">
							<c:param name="taskId" value="${tempItem.id}" />


						</c:url>
						<!-- CONSTRUCT DELETE LINK WITH TASK ID -->
						<c:url var="deleteLink" value="/todolist/deleteTask">
							<c:param name="taskId" value="${tempItem.id}" />


						</c:url>

						<tr>
							<td>${tempItem.id}</td>
							<td>${tempItem.title}</td>
							<td>${tempItem.date}</td>
							<td>${tempItem.status}</td>
							<td>
								<!-- DISPLAY THE EDIT LINK --> <a href="${editLink}">Edit</a> <!-- DISPLAY THE DELETE LINK -->
								<a href="${deleteLink}"
								onClick="if(!(confirm('Are You Sure You Want To Delete This Task?'))) return false">Delete</a>


							</td>



						</tr>



					</c:forEach>

				</tr>

			</table>

		</div>

	</div>



</body>


</html>