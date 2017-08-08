<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
$(function()
		{
		$("#datepicker").datepicker();
		});
</script>
</head>
<body>
<fieldset>
<div align="center">
<h2>Schedule Training</h2>
<form action="trainer/schedule" method="POST" autocomplete="off">
<table id="insertSchedule">
<tr>
<td>Trainer id:</td>
<td><input type="text" name="trainerId" required pattern="^([0-9]{5})+$" title="Enter your 5 digit trainer id"></td>
<td>Trainer Name:</td>
<td><input type="text" name="trainerName" required pattern="^[A-Za-z ]+$" title="Enter only alphabets"></td>
</tr>
<tr>
<td>College Name:</td>
<td><input type="text" name="collegeName" required pattern="^[A-Za-z ]+$" title="Enter only alphabets"></td>
<td>Domain</td>
<td>
<select name="domain" required>
<c:forEach var="list" items="${domainList}">
<option value="${list}">${list}</option>
</c:forEach>
</select> 
</td>
</tr>
<tr>
<td>Start date:</td>
<td><input type="text" name="startDate" id="datepicker" required></td>
<td>Duration in minute:</td>
<td><select name="duration" required>
<c:forEach var="list" items="${durationList}">
<option value="${list}">${list}</option>
</c:forEach>
</select> </td>
</tr>
</table>
<button>SUBMIT</button>
</form>
</div>
</fieldset>
</body>
</html>