<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>World Adventure Airlines</title>
</head>
<body>

	<div class="container">
		<div class="title">Add a passenger</div>
		<%
			if ((Boolean) request.getAttribute("errors") != null) {
		%>
		<fieldset>
			<legened>Error occured</legened>
			<ul>
				<%
					if ((Boolean) request.getAttribute("firstname_error") != null) {
				%>
				<li>First name error</li>
				<%
					}
				%>
				<%
					if ((Boolean) request.getAttribute("lastname_error") != null) {
				%>
				<li>Last name error</li>
				<%
					}
				%>
				<%
					if ((Boolean) request.getAttribute("date_error") != null) {
				%>
				<li>Date error</li>
				<%
					}
				%>
			</ul>
		</fieldset>
		<%
			}
		%>
		<fieldset>
			<legend>Passenger details</legend>
			<form action="AddPassenger" method="post">
				<div class="inputField">
					<label for="first-name" class="inputlabel">First name: </label> <input
						name="first-name" type="text" value=<%= request.getAttribute("first-name") %>></input>
				</div>
				<div class="inputField">
					<label for="last-name" class="inputlabel">Last name: </label> <input
						name="last-name" type="text" value=<%= request.getAttribute("last-name") %>></input>
				</div>
				<div class="inputField">
					<label for="dob" class="inputlabel">Date of birth: </label> <input
						name="dob" type="text" value=<%= request.getAttribute("dob") %>></input>
				</div>
				<div class="inputField">
					<label for="first-name" class="inputlabel">Gender: </label> <select
						name="gender">
						<option label="Male">Male</option>
						<option label="Female">Female</option>
					</select>
				</div>
		</fieldset>
		<div class="inputfield" id="submitField">
			<input id="submitBtn" type="submit" value="Add new passenger"></input
		</div>
		</form>

	</div>
</body>
</html>