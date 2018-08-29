<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%@ include file="BarreNav.jsp"%>

	<div class="container" id="content">
		<div class="row">
			<h2>Client List</h2>
			<table id="carTable" class="table table-striped">
				<thead>
					<tr>
						<th>id</th>
						<th>brand</th>
						<th>model</th>
						<th>plateNumber</th>
						<th>price</th>
						<th>kms</th>
						<th>cv</th>
						<th>price</th>
					</tr>
				</thead>
				<c:forEach items="${ cars }" var="car">
					<tbody>
						<tr>
							<td><c:out value="${ car.id }" /></td>
							<td><c:out value="${ car.brand }" /></td>
							<td><c:out value="${ car.model }" /></td>
							<td><c:out value="${ car.plateNumber }" /></td>
							<td><c:out value="${ car.price }" /></td>
							<td><c:out value="${ car.kms }" /></td>
							<td><c:out value="${ car.cv }" /></td>
							<td><c:out value="${ car.color }" /></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>