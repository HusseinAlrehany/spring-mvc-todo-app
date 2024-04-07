<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
<header>
	<title>Add NEW Task</title>


	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">


	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">



</header>

<body>

	<div id="wrapper">

		<div id="header">

			<h2>Add New Task To The List</h2>

		</div>


	</div>

	<div id="container">


		<h3>Add A Task</h3>

		<form:form action="addnewtask" modelAttribute="tasks" method="POST">
			<!-- FOR UPDATING THE TASK -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>Id</label></td>
						<td><form:input path="id" /></td>


					</tr>
					<tr>
						<td><label>Title</label></td>
						<td><form:input path="title" /> <form:errors path="title"
								cssClass="error" /></td>

					</tr>
					<tr>
						<td><label>Date</label></td>
						<td><form:input path="date" /> 
						<form:errors path="date" /></td>

					</tr>
					<tr>
						<td><label>Status</label></td>
						<td><form:input path="status" /> <form:errors path="status" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save Task" class="add-button" /></td>
						<td><input type="reset" value="Reset" class="add-button" /></td>
					</tr>


				</tbody>


			</table>





		</form:form>

	</div>




</body>



</html>