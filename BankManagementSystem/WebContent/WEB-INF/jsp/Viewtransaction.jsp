<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
</head>
<body>
	<a href="/BankManagementSystem/"><h1>${headerText}</h1></a>
	<a href="/BankManagementSystem/">Home</a>
	<fieldset style="width: 580px;">
		<legend>View transaction</legend>
		<table>
			<tr>
				<td>AccountNumber</td>
				<td><input type="text" placeHolder="Account Number"
					id="accountNumber" /></td>
				<td id="AccountNumberError" class="error"></td>
			</tr>
			<tr>
				<td>Transaction Id</td>
				<td><input type="text" placeholder="Transaction Id"
					id="transactionId" /></td>
				<td id="TransactionError" class="error"></td>
			</tr>
			<tr>
				<td><input id="submit" type="button" value="Submit" /></td>
			</tr>
		</table>
	</fieldset>

	<div id="tableDiv"
		style="width: 600px; border: 1px solid black; padding: 3px;">
		<table id="example" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Account Number</th>
					<th>Transaction Id</th>
					<th>Transaction Type</th>
					<th>Description</th>
					<th>Balance</th>
				</tr>
			</thead>
		</table>
	</div>
	<script>
		$(document).ready(function() {
			$('#tableDiv').hide();
			$('#example').hide();
		});
		$("#submit")
				.click(
						function() {
							var accountNumber = $("#accountNumber").val();
							var transactionId = $("#transactionId").val();

							if (accountNumber.length > 0
									|| transactionId.length > 0) {
								if ((accountNumber.length == 16 && accountNumber
										.match("[0-9]{16}"))
										|| (transactionId.length == 10 && transactionId
												.match("[0-9]{10}"))) {

									$("#TransactionError").html("");
									$("#AccountNumberError").html("");
									$
											.ajax({
												headers : {
													Accept : "application/json; charset=utf-8"
												},
												type : "GET",
												url : "viewTransaction",
												dataType : "json",
												data : {
													accountNumber : accountNumber,
													transactionId : transactionId
												},
												success : function(data) {

													if (data) {
														$('#tableDiv').show();
														$('#example').show();
														$('#example')
																.dataTable(
																		{
																			destroy : true,
																			searching : false,
																			"bProcessing" : true,
																			"aaData" : data,
																			"columns" : [
																					{
																						"data" : "accountNumber"
																					},
																					{
																						"data" : "transactionID"
																					},
																					{
																						"data" : "transactionType"
																					},
																					{
																						"data" : "transactionDescription"
																					},
																					{
																						"data" : "accountBalance"
																					}

																			]
																		});
													}
												},
												error : function() {

													$("#AccountNumberError")
															.html(
																	"Account Number should be 16 digit number");
													$("#TransactionError")
															.html(
																	"Transaction Id should be 10 digit number");
												}

											});
								} else {
									$("#AccountNumberError")
											.html(
													"Account Number should be 16 digit number");
									$("#TransactionError")
											.html(
													"Transaction Id should be 10 digit number");
								}
							} else {
								$("#AccountNumberError").html(
										"Atleast one field is required");
							}
						});
	</script>
</body>
</html>