<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	$("#datepicker").datepicker();
});

function show()
{
	$("#listSchedule").show();
	}
</script>
<style type="text/css">
#listSchedule th,td{
    border: 1px solid black;
    
}
#listSchedule{
    border: 1px solid black;
    
}
</style>
</head>
<body>
<fieldset>
<div align="center">
<h2>Show Weekly Schedule Detail</h2>
<c:url value="/view/schedule.html" var="action"></c:url>
<form:form action="${action}" commandName="schedule" method="GET">
<table>
<tr>
<td>Start date</td>
<td><form:input path="startDate" id="datepicker"/>
</tr>
</table>
<button>SHOW</button>
</form:form>
</div>
</fieldset>
<center>
<table id="listSchedule" style="display:none;">
<thead>
<tr>
<th>Trainer</th>
<th>College</th>
<th>Domain</th>
<th>Date</th>
<th>Duration</th>
</tr>
</thead>
<c:if test="${!empty list}">
<c:forEach items="${list}" var="schedule">
<tr>
<td>${schedule.trainerName}</td>
<td>${schedule.collegeName}</td>
<td>${schedule.domain}</td>
<td>${schedule.startDate}</td>
<td>${schedule.duration}</td>
</tr>
</c:forEach>
<script type="text/javascript">
show();
</script>
</c:if>

</table>
</center>
</body>
</html>