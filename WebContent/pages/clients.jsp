<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%@ include file="BarreNav.jsp"%>
	<div class="container" id="content">
		<div class="row">
		
		
		
		<c:if test="${msgReservation != null }">
		
		<h2 style="color:green"><c:out value="${msgReservation}" /></h2>
		
		
		</c:if>
		
		
		<br>
			<h2>Client List</h2>
			<table id="userTable" class="table table-striped">
				<thead>
					<tr>
						<th>Login</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Reservation</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${clients}" var="client">
						<tr>
							<td><c:out value="${ client.id}" /></td>
							<td><c:out value="${ client.login }" /></td>
							<td><c:out value="${ client.firstName }" /></td>
							<td><c:out value="${ client.lastName }" /></td>
							<td><c:out value="${ client.mail }" /></td>
							<td>
								<form action="./reservation" method="get">
									<div>
										<label for="startDate">Start</label> <input type="Date"
											name="startDate" id="startDate" required />
									</div>
									<div>
										<label for="endDate">End</label> <input type="Date"
											name="endDate" id="endDate">
									</div>
									<input type="hidden" value="${ client.id }" id="login"
										name="login" required />
									<button>Rental</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>