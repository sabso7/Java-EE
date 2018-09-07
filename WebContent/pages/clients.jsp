<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%@ include file="BarreNav.jsp"%>
	<div class="container" id="content">
		<div class="row">

			<c:if test="${msgReservation != null}">
				<h2 style="color: green">
					<c:out value="${msgReservation}"/>
				</h2>
			</c:if>
			
			<br>
			<h2>Client List</h2>
			<table id="userTable" class="table table-striped">
				<thead>
					<tr>
						<th>Login</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Your Reservation</th>
						<th>Go rent ! </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${clients}" var="client">
						<tr>	
							<td><c:out value="${ client.login }" /></td>
							<td><c:out value="${ client.firstName }" /></td>
							<td><c:out value="${ client.lastName }" /></td>
							<td><c:out value="${ client.mail }" /></td>
							
							<c:forEach items="${reservations}" var="reservation">
							<c:if test="${reservation == null }"><p>pas de reservation</p></c:if>
										<c:if test="${client.id eq reservation.client}">
											<td>Car :<c:out value="${ reservation.car}" /> Prix :<c:out value="${ reservation.price}" />
											<form action="./clients" method="post">
											<input type="hidden" value="${reservation.id}" id="delete" name="delete"/><button>Delete</button></td>
											</form>
										</c:if>
								</c:forEach>
							<td>
								<form action="./clients" method="post">
									<div>
										<label for="startDate">Start</label> <input type="Date"
											name="startDate" id="startDate" required />
									</div>
									<div>
										<label for="endDate">End</label> <input type="Date"
											name="endDate" id="endDate" required>
									</div>
									<input type="hidden" value="${client.id}" id="goRent" name="goRent"/><button>GoRent</button>	
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