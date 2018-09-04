<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reservation d'un véhicule</title>
</head>
<body>
<%@ include file="BarreNav.jsp"%>

<fieldset>
    <legend>Choose trip dates</legend>
                	
<!--  <p>Bonjour  -->
<%--  <c:out value="${ client.firstName }" /> --%>
<%--  <c:out value="${ client.lastName }" /> --%>
<!--  </p> -->
 
 </br>


<form method ="post">

   <div>
        <label for="startDate">Start</label>
        <input type="Date" name="startDate" id="startDate" />
    </div>

    <div>
        <label for="endDate">End</label>
        <input type="Date" name="endDate" id="endDate"  >
    </div>
    
    <label >Véhicules libres</label>
                
                <select type="car" class="form-control" required autofocus id="car" name="car" >    
                	<c:forEach   items="${cars}" var="car">
                		<option value="${car.brand} ${car.model}">${car.brand} ${car.model}</option>
					</c:forEach> 
				</select>
				
				<input type="submit" />

			
				
	<div><c:out value ="vous avez selectionné le véhicule suivant : ${car.brand} ${car.model} ${car.price}"/><br>
		 <c:out value ="son prix au kilomètre est : ${car.kms}, son prix de location est de : ${car.price}"/>
	</div>			
	<div> 
		<label for="TotalPrice">Estimez votre kilométrage</label>
		<input type="number" name="kilometer" id="kilometer" />	<br>
		<c:out value="Vous optez pour : ${Kilometer} kilomètres"/>
	</div>
	
	<div>
		<c:out value ="Prix : ${car.brand} ${car.model} ${car.price}"/><br>
		<c:out value ="son prix au kilomètre est : ${kms.price}"/>
	</div>
	
	

				
				<c:out value="${param.date}"/>
				<c:out value="${param.date}"/>


</form>
</fieldset>


</body>
</html>
