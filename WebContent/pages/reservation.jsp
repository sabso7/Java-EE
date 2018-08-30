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

    <div>
        <label for="start">Start</label>
        <input type="date" id="start" name="trip"
               value="2018-07-22"
               min="2018-01-01" max="2018-12-31" />
    </div>

    <div>
        <label for="end">End</label>
        <input type="date" id="end" name="trip"
               value="2018-07-29"
               min="2018-01-01" max="2018-12-31"/ >
    </div>

</fieldset>


</body>
</html>