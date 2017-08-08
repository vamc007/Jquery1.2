<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction page</title>
</head>
<body>
<a href="/BankManagementSystem/"><h1>${headerText}</h1></a>
<a href="/BankManagementSystem/">Home</a>
<%-- <p style="color:red;"><form:errors path="transactionForm.*"/></p> --%>

<p><spring:message code="label.language"/> <a href="/BankManagementSystem/startTransaction?language=en_US">English</a>|<a href="/BankManagementSystem/startTransaction?language=fr_FR">French</a></p>
<form action="/BankManagementSystem/initateTransaction" method="post">
  <fieldset style="width: 580px;">
    <legend><spring:message code="label.legend"/></legend>
    <table>
    <tr>
    	 <!-- <td>Account Number:</td> -->
    	<td><spring:message code="label.accountNumber"/></td>
    	<td><input type="text" name="accountNumber"></td>
		<td><p style="color:red;"><form:errors path="transactionForm.accountNumber"/></p></td>
    </tr>
    <tr>
    	<td><spring:message code="label.transactionId"/></td>
    	<td><input type="text" value="${nextTransactionId}" disabled></td>
    </tr>
    <tr>
    	<td><spring:message code="label.transactionType"/></td>
    	<td><select name="transactionType">
    		<option disabled selected value>-- select an option --</option>
			<option>Deposit</option>
  			<option>Withdrawal</option>
		</select> </td>
		<td><p style="color:red;"><form:errors path="transactionForm.transactionType"/></p></td>
    </tr>
    <tr>
    	<td><spring:message code="label.transactionAmount"/></td>
    	<td><input type="text" name="accountBalance"></td>
    	<td><p style="color:red;"><form:errors path="transactionForm.accountBalance"/></p></td>
    </tr>
    <tr>
    	<td><spring:message code="label.description"/></td>
    	<td><textarea rows="4" cols="21"  name="transactionDescription"></textarea></td>
    	<td><p style="color:red;"><form:errors path="transactionForm.transactionDescription"/></p></td>
    </tr>
    <tr>
    	<td colspan="2"><button type="submit" value="submit"><spring:message code="label.submit.transactionForm"/></button></td>
    </tr>
    </table>
  </fieldset>
</form>
</body>
</html>