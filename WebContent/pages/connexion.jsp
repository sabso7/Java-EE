<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>
<body>
<%@ include file="BarreNav.jsp"%>
<c:if test="${!empty form.resultat}"><p><c:out value="${form.resultat}"/></p></c:if>

<form method="post" action="./connexion">
<p>
<label for="pseudo">Login :</label>
<input type="text" name="pseudo" id="pseudo" class="form-control" required />
</p>
<p>
<label for="password">Password :</label>
<input type="password" name="password" id="password" class="form-control" required />
</p>
	<input type="submit" />


</form>

</body>
</html>